package com.werson.services.lock;

import java.util.concurrent.atomic.AtomicBoolean;

public class FakeLimitedResource {

    private final AtomicBoolean inUse = new AtomicBoolean(false);

    public void use() throws InterruptedException {
        if (!inUse.compareAndSet(false, true)) {
            throw new IllegalStateException("Needs to be used by one client at a time");
        }
        try {
            Thread.sleep(1000);
        } finally {
            inUse.set(false);
        }
    }

}
