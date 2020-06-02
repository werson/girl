package test.jdkproxy;

import java.util.Random;

/**
 * test.jdkproxy
 *
 * @author werson
 * @version 1.0.0
 * @since 2019/3/21
 */
public class Car implements Moveable {
    @Override
    public void move() {
        try {
            System.out.println("car is moving .....");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void print(String text) {
        System.out.println("text is ===" + text);
    }
}
