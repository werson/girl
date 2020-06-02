package com.werson.jvm;

/**
 * com.werson.jvm
 *
 * @author werson
 * @version 1.0.0
 * @since 2019/3/27
 */
public class Digui {

    private Long i = 0L;

    public void add(){
        i++;
        System.out.println("result =" + i);
        add();
    }

    public static void main(String[] args) {
        Digui digui = new Digui();
        digui.add();
    }


}
