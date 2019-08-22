package com.swan.dao.aop;


import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

public class SwanRoutingPointCut implements Pointcut,MethodMatcher,ClassFilter {

    @Override
    public boolean matches(Class<?> aClass) {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return false;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
