package com.bjpowernode.util;

public class ServiceFactory {
    public static Object factory(Object obj){
        return new TransactionInvocationhandler(obj).utilProxy();
    }
}
