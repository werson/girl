package com.werson.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wersom on 2017/10/12 0012.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String identifier() default "";
    int num () default  0;
}
