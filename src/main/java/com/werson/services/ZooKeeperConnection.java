package com.werson.services;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooKeeperConnection {

    /**
     * zk实例.
     */
    private ZooKeeper zooKeeper;
    private static final String HOST = "127.0.0.1";
    private final CountDownLatch connectedSignal = new CountDownLatch(1);

    public ZooKeeper connect() throws IOException,InterruptedException {

        zooKeeper = new ZooKeeper(HOST,5000, watchedEvent -> {
            if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                connectedSignal.countDown();
            }
        });
        connectedSignal.await();
        return zooKeeper;
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }

}
