package com.werson.thread.future;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.twitter.util.Future;
import com.twitter.util.FuturePool;
import com.twitter.util.FuturePools;
import com.twitter.util.Futures;
import com.twitter.util.Try;
import org.assertj.core.util.Lists;
import org.junit.Test;
import scala.runtime.BoxedUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class FutureTest2 {

    @Inject
    @Named("")
    private FuturePool pool = null;

    public static void main(String[] args) throws Exception {
        //List<Future<String>> futures = Lists.newArrayList();
        //futures.add(Future.value("a"));

        /*Future.collectToTry(futures).map(list -> {
           list.stream().map(Try::get).forEach(System.out::println);
        });*/


    }

    public Future<Object> getAddNumber(int num) {
        int count = 0;
        for (int i = 1; i < num; i++){
            count += i;
        }
        return Future.value(count);
    }

    @Test
    public void test1() {
        //FuturePool pool = FuturePools.IMMEDIATE_POOL;

        Future<Object> result = Futures.flatten(pool.apply(() -> getAddNumber(100)));
        result.onSuccess(res -> {
            int a = (Integer) res;
            System.out.println("a = " + a);
            return BoxedUnit.UNIT;
        });
    }

}
