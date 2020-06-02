package com.werson.mock;

import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * com.werson.mock
 * @author werson
 * @version 1.0.0
 * @since 2019/4/21
 */
public class MockTest {

    @Test
    public void addTest(){
        Assert.assertEquals(1, new Mock().add());
    }

    @Test
    public void test1(){
        Mock mock = Mockito.mock(Mock.class);
        Mockito.when(mock.add()).thenReturn(1);
        Assert.assertEquals(1, mock.add());


    }

    public void setUp () {
        System.out.println("gg");
    }

/*    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new MockTest());
        suite.addTest(new Mock().add());
        return suite;
    }*/

}
