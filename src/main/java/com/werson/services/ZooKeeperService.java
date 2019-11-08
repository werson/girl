package com.werson.services;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import static org.apache.zookeeper.Watcher.Event.KeeperState.Expired;

public class ZooKeeperService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZooKeeperService.class);
    private static final String HOST = "127.0.0.1";
    private ZooKeeper zooKeeper;
    private static final CountDownLatch CONNECTED_SIGNAL = new CountDownLatch(1);

    public static void main(String[] args) throws KeeperException, InterruptedException {

        //zooKeeperService.create("/lock/test","0".getBytes());
        ZooKeeperService zooKeeperService = new ZooKeeperService();
        zooKeeperService.update("/lock/test", "1".getBytes());
        zooKeeperService.destroy();
        /*new Thread(() -> {
            try {
                ZooKeeperService zooKeeperService = new ZooKeeperService();
                zooKeeperService.update("/lock/test2", "0".getBytes());
                zooKeeperService.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();*/

        /*new Thread(() -> {
            try {
                ZooKeeperService zooKeeperService = new ZooKeeperService();
                String value = zooKeeperService.getData("/lock/test");
                LOGGER.info("value =========" + value);
                zooKeeperService.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();*/


    }

    private ZooKeeperService() {
        try {
            Watcher defaultWatcher = new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                        CONNECTED_SIGNAL.countDown();
                    }
                }
            };
            zooKeeper = new ZooKeeper(HOST, 5000,defaultWatcher);
            CONNECTED_SIGNAL.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void create(String path, byte[] data) throws
            KeeperException,InterruptedException {
        zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }

    public Stat znodeExists(String path) throws KeeperException,InterruptedException {
        return zooKeeper.exists(path, true);
    }

    public String getData(String path) throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.None) {
                    if(watchedEvent.getState() == Expired){
                        CONNECTED_SIGNAL.countDown();
                    }
                }else {
                    try {
                        zooKeeper.getData(path, false, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        CONNECTED_SIGNAL.countDown();
                    }
                }
            }
        }, null);
        return new String(data, StandardCharsets.UTF_8);
    }

    public void update(String path, byte[] data) throws KeeperException,InterruptedException {
        zooKeeper.setData(path, data, zooKeeper.exists(path,true).getVersion());
    }

}
