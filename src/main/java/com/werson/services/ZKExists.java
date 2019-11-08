package com.werson.services;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZKExists {
    private static final Logger logger = LoggerFactory.getLogger(ZKCreate.class);

    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    public static Stat znodeExists(String path) throws
            KeeperException,InterruptedException {
        return zk.exists(path, true);
    }

    public static void main(String[] args) {
        String path = "/MyFirstZnode";

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect();
            Stat stat = znodeExists(path);

            if(stat != null) {
                logger.error("Node exists and the node version is " +
                        stat.getVersion());
            } else {
                logger.error("Node does not exists");
            }
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
    }
}
