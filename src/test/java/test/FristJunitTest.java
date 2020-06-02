package test;

import org.junit.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wersom on 2017/10/13 0013.
 */
public class FristJunitTest {
    @Test
    public void test1(){
        System.out.println("hello junit!");
    }

    @Test
    public void test2(){
        System.out.println("hello junit!");
        Assert.assertEquals(1,1);
    }

    public static void main(String[] args) {
        int size = 100;
        AtomicInteger indexOne = new AtomicInteger(0);
        AtomicInteger indexTwo = new AtomicInteger(99);
        final AtomicBoolean isEncountered = new AtomicBoolean(Boolean.FALSE);
        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < size; i++){
                    System.out.println("线程1输出：" + i);
                    if(isEncountered.get()){
                        return;
                    }
                    indexOne.set(i);
                    if((indexOne.get()+1)==indexTwo.get()){
                        isEncountered.set(Boolean.TRUE);
                        return;
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for(int i = (size-1); i > -1; i--){
                    System.out.println("线程2输出：" + i);
                    if(isEncountered.get()){
                        return;
                    }
                    indexTwo.set(i);
                    if((indexOne.get()+1)==indexTwo.get()){
                        isEncountered.set(Boolean.TRUE);
                        return;
                    }
                }
            }
        }.start();

        while (true){
            if(isEncountered.get()){
                System.out.printf("\n两个线程相遇在 %d,%d\n", indexOne.get(), indexTwo.get());
                break;
            }
        }


    }

}
