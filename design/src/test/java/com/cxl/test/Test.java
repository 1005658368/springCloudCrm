package com.cxl.test;


import com.cxl.proxy.Meipo;
import com.cxl.proxy.Person;
import com.cxl.proxy.XiaoXingxing;

public class Test {
    @org.junit.Test
    public void test1() throws Exception {
        System.out.println("cx1");
        Person obj = (Person)new Meipo().getInstance(new XiaoXingxing());
        System.out.println(obj.getClass());
        obj.findLove();

        //原理：
        //1.拿到被代理对象的引用，然后获取它的接口
        //2.JDK代理重新生成一个类，同时实现我们给的代理对象所实现的接口
        //3.把被代理对象的引用也拿到了
        //4.重新动态生成一个class字节码
        //5.然后编译

        //获取字节码内容
//            byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});  //生成字节码文件
//            FileOutputStream os = new FileOutputStream("E:/GP_WORKSPACE/$Proxy0.class");  //将字节码输入到磁盘上
//            os.write(data);
//            os.close();

        //是什么?
        //为什么？
        //怎么做？
        //解释： 字节码 反编译后 可以查看

//        Person obj1 = (Person)new GPMeipo().getInstance(new XiaoXingxing()); //返回一个代理对象   代理出来的这个对象可以强转这个接口类
//        System.out.println(obj1.getClass()); //这个Object对象  并不是 lcy的引用了 完全是一个新的对象
//        obj.findLove();  //动态代理 需要调用哪个方法 就调用哪个方法   整个类都是新的类了 新的字节码
    }
}
