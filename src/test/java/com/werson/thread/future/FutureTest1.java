package com.werson.thread.future;

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