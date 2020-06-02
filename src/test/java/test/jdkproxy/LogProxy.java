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
public class LogProxy implements InvocationHandler {

    private Object target;

    public LogProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before log....");

        method.invoke(target);

        System.out.println("after log ....");
        return null;
    }
}
