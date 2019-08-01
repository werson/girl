package com.werson.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class FutureTest1 {

    public FutureTest1.Printer getPrinter(){
        return new Printer();
    }

    private class Printer{
        private String name;
        public String getName(){
            return this.name;
        }
    }


    public static void main(String[] args) {
        List<User> a = new ArrayList<>();
        /*User b = new User();
        b.setAge(1);
        b.setName("1");

        a.add(b);

        b.setAge(2);
        b.setName("2");
        a.add(b);

        b.setAge(3);
        b.setName("3");
        a.add(b);
        System.out.println(a.size());*/
        for(User u : a){
            System.out.println(u.getName());
        }


        // java8 避免空指针的使用方法  Optional
        /*FutureTest1 futureTest1 = new FutureTest1();
        FutureTest1.Printer printer = futureTest1.getPrinter();
        Optional.of(printer).map(FutureTest1.Printer::getName)
                .map(String::length).ifPresent(System.out::println);*/


        /*ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(()->{
            System.out.println("thread:"+ Thread.currentThread().getName() +" running ");
            Thread.sleep(6000);
            return "a";
        });

        try {
            String result = future.get(5, TimeUnit.SECONDS);
            System.out.println("result : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!service.isShutdown()){
            service.shutdown();
        }*/

        /*List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(()->{
            System.out.println("gagag");
            return "1";
        });
        callableList.add(()->{
            System.out.println("haha");
            return "2";
        });
        callableList.add(()->{
            System.out.println("jaja");
            return "3";
        });
        try {
            service.invokeAll(callableList).stream()
                    .map(a -> {
                        try {
                            return a.get();
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        return "";
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }

}
final class User{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}