package com.werson.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wersom on 2017/8/17 0017.
 */
public class ThreadPoolTest {

    private int poolSize = 5;

    ThreadPoolTest(int size) throws ExecutionException, InterruptedException {
        this.poolSize = size;

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        List<Future> list = new ArrayList<Future>();
        for(int i = 0; i < poolSize; i++){
            Callable c = new MyCallable(i + "");
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();

        for(Future f : list){
            System.out.println(f.get().toString());
        }
    }

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        ThreadPoolTest poolTest = new ThreadPoolTest(10);
    }
}
