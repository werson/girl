package com.werson.services.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;

public class SharedReentrantLockTest {

    private static final Integer CLIENT_NUMS = 5;
    private static final String HOST = "127.0.0.1";
    final static FakeLimitedResource resource = new FakeLimitedResource();
    private static CountDownLatch countDownLatch = new CountDownLatch(CLIENT_NUMS);

    public static void main(String[] args) {
        for (int i = 0; i < CLIENT_NUMS; i++) {
            String clientName = "client#" + i;
            new Thread(() -> {
                CuratorFramework client = getClient();

            }).start();
        }
    }

    public static synchronized CuratorFramework getClient() {
        return CuratorFrameworkFactory.builder().connectString(HOST)
                .sessionTimeoutMs(6000).connectionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
    }

}
