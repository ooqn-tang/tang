package net.ttcxy.tang.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo2 implements InvocationHandler {

    Object target;

    public Demo2(Object target){
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    public static void main(String[] args) throws Exception {
        Demo2 demo2 = new Demo2(new Demo3());
        Demo3 demo3 = demo2.getProxy();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do something before");
        Object result = method.invoke(target, args);
        System.out.println("Do something after");
        return result;
    }
}
