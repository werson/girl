package test.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * test.jdkproxy
 *
 * @author werson
 * @version 1.0.0
 * @since 2019/3/21
 */
public class Test {

    public static void main(String[] args) {

        Car car = new Car();
        TimeProxy timeProxy = new TimeProxy(car);
        Class c = car.getClass();
        Moveable moveable = (Moveable) Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), timeProxy);


        LogProxy logProxy = new LogProxy(moveable);
        Class mc = moveable.getClass();
        Moveable l = (Moveable) Proxy.newProxyInstance(mc.getClassLoader(), mc.getInterfaces(), logProxy);
        l.move();


        //Moveable moveable2 = (Moveable) Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), logProxy);
        //moveable2.move();
        //moveable.print("gaga");

    }

}
