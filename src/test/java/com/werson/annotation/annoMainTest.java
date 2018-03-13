package com.werson.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by wersom on 2017/10/12 0012.
 */
public class AnnoMainTest {
    public static void main(String[] args) {
        try{
            Class aclass = Class.forName("com.werson.annotation.UpperLoadTest");
            //执行方法
            /*UpperLoadTest aUpper = (UpperLoadTest)aclass.newInstance();
            aUpper.doUpperLoad();*/
            //获取注释某个值
            if(aclass.isAnnotationPresent(Component.class)) {
                Component component = (Component)aclass.getAnnotation(Component.class);
                String identifier = component.identifier();
                int num = component.num();
                System.out.println(String.format("Identifier is ' %s %d'", identifier, num));
            } else {
                System.out.println("not found");
            }
            Annotation[] annotations = aclass.getAnnotations();
            for(Annotation a : annotations){
                System.out.println(a.annotationType());
                System.out.println(a.equals(a));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
