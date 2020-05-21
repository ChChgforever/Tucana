package com.tucana;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class TcConfiguration {

    public static final ResourceBundle SQL_BUNDLE;

    static {
        SQL_BUNDLE = ResourceBundle.getBundle("sql");
    }

    public <T> T getMapper(Class clazz, TcSqlSession tcSqlSession) {
        return (T)
                Proxy.newProxyInstance(
                        this.getClass().getClassLoader(),
                        new Class[] {clazz},
                        new MapperProxy(tcSqlSession));
    }
}
