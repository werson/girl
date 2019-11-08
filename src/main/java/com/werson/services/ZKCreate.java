package com.werson.services;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZKCreate {

    private static final Logger logger = LoggerFactory.getLogger(ZKCreate.class);

    private static ZooKeeper zk;

    private static ZooKeeperConnection conn;

    public static void create(String path, byte[] data) throws
            KeeperException,InterruptedException {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }

    public static void main(String[] args) {

        String path = "/MyFirstZnode";
        byte[] data = "My first zookeeper app".getBytes();

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect();
            create(path, data);
            conn.close();
        } catch (Exception e) {
            logger.error(e.getMessage()); //Catch error message
        }
    }
}
