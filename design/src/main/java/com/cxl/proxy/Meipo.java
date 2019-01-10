package com.cxl.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//媒婆
public class Meipo implements InvocationHandler {

    private Person target; //被代理对象的引用作为一个成员变量保存下来了   在下面调用时候的 的   ///////////////////////// 下面的嗲用

    //获取被代理人的个人资料为，为了能让他代理任何对象
    public Object getInstance(Person target) throws Exception {
        this.target = target;
        Class clazz = target.getClass();  //利用反射机制（最终获得接口）
        System.out.println("被代理对象的class是:" + clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);  //this这个参数 指的是 代理人 this.h   就是调用了媒婆的 invoke方法    this指的是invoke这个回调方法
    }
    //代理对象 会自动调用下面invoke方法
    @Override
    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable{

        System.out.println("我是媒婆：" + "得给你找个异性才行");
        System.out.println("开始进行海选...");
        System.out.println("------------");
        //调用的时候   （利用反射机制调用）   对象名.方法名
        method.invoke(this.target, args);  //这个invoke不是方法名字的invoke  是的话 会陷入死循环
        System.out.println("------------");
        System.out.println("如果合适的话，就准备办事");

        return null;
    }

}
