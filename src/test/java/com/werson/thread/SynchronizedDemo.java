package com.werson.thread;

/**
 * Created by wersom on 2017/8/17 0017.
 */
public class SynchronizedDemo {
    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    public void write(){
        ready = true;
        number += 2;
        System.out.println("result = "+result);
    }

    public void read(){
        if(ready){
            result = number*3;
        }
        System.out.println("result = "+result);
    }

    private class ReadWriteThread extends Thread {
        private boolean flag;
        public ReadWriteThread(boolean flag){
            this.flag = flag;
        }

        public void run(){
            if(flag){
                write();
            } else {
                read();
            }
        }
    }

    private class ThreadTest implements Runnable {
        private boolean flag;
        public ThreadTest(boolean flag){
            this.flag = flag;
        }
        public void run(){
            if(flag){
                write();
            } else {
                read();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        Thread threadWrite = synchronizedDemo.new ReadWriteThread(true);
        threadWrite.start();
        Thread threadWrite2 = synchronizedDemo.new ReadWriteThread(false);
        //threadWrite2.start();

        ThreadTest threadTeset = synchronizedDemo.new ThreadTest(false);
        Thread thread1 = new Thread(threadTeset);
        thread1.start();
    }

}
