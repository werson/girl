package test.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * test.jdkproxy
 *
 * @author werson
 * @version 1.0.0
 * @since 2019/3/21
 */
public class TimeProxy implements InvocationHandler {

    private Object m;

    public TimeProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("start time is " + startTime);
        method.invoke(m, args);
        long endTime = System.currentTimeMillis();
        System.out.println("use time is " + (endTime - startTime));
        return null;
    }
}
