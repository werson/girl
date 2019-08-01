package com.werson.thread.future;

import com.twitter.util.Future;
import com.twitter.util.Try;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class FutureTest2 {

    public static void main(String[] args) {
        List<Future<String>> futures = Lists.newArrayList();
        futures.add(Future.value("a"));

        /*Future.collectToTry(futures).map(list -> {
           list.stream().map(Try::get).forEach(System.out::println);
        });*/
    }

}
