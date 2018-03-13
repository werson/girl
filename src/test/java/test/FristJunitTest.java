package test;

import org.junit.*;
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

}
