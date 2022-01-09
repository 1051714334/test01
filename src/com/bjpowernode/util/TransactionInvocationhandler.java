package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationhandler implements InvocationHandler {
    private Object target;
    public TransactionInvocationhandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=null;
        SqlSession sqlSession=null;
        try{
            sqlSession=SqlSessionUtil.getSqlSession();
            obj=method.invoke(target,args);
            sqlSession.commit();
        }
        catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally{
            SqlSessionUtil.myClose(sqlSession);
        }
        return obj;
    }
    public Object utilProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
