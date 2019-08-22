package com.swan.dao.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;

@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Router {

    @AliasFor("alias")
    String value();

    @AliasFor("value")
    String alias();

}
