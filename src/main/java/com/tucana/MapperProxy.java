package com.tucana;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private TcSqlSession tcSqlSession;

    public MapperProxy(TcSqlSession tcSqlSession) {
        this.tcSqlSession = tcSqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        System.out.println("className: " + className);
        System.out.println("methodName: " + methodName);
        return tcSqlSession.selectOne(className + "." + methodName, args[0]);
    }
}
