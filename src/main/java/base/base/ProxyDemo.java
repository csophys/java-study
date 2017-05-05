package base.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * Created by csophys on 16/10/18.
 */
public class ProxyDemo {


    // Object result = method.invoke(helloService,args);
    // Proxy.newProxyInstance返回的是helloService的实例
    // method.invoke(helloService1,args) 取决于最终invoker的对象是什么类型。

    /**
     * 1处 method.invoke(helloService1,args) 赋值给返回值。 返回的是helloService1的类型
     * 0处返回的是""
     *
     Object result1 = new HelloServiceImpl();
     Object result2 = method.invoke(helloService1,args);
     Object result3 = method.invoke("hello",args);
     System.out.println("after invoke");
     return result3;

     返回的是"hello"


     if(method.isBridge()){
     return method.invoke(helloService1,args);
     }else{
     return method.invoke("hello",args);
     }
     返回的是"hello"

     if(method.isBridge()){
     return method.invoke(helloService1,args);
     }else if(true){
     return method.invoke("hello",args);
     }else{
     return method.invoke(new ArrayList<>(),args);
     }
     返回的是"hello"

     if(true){
     return method.invoke(helloService1,args);
     }else if(false){
     return method.invoke("hello",args);
     }else{
     return method.invoke(new ArrayList<>(),args);
     }
     返回的是HelloServiceImpl

     * @param args
     */

    public static void main(String[] args) {
        //1. 真实的示例引用
        HelloService helloService = new HelloServiceImpl();
/*
        //2. 创建代理类实例
        HelloService result = (HelloService)Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{HelloService.class}, new MyInvocationHandler(new HelloServiceImpl()));
        //3. 调用方法
        System.out.println(result.hello("csophys"));
*/

        HelloService proxy = getProxy(HelloService.class,"test");
//        System.out.println(proxy);
    }

    public static <T> T getProxy(Class<T> targetClass,String target){
        HelloServiceImpl helloService1 = new HelloServiceImpl();
        T t = (T) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(),new Class[]{targetClass},new MyInvocationHandler(helloService1));
        return t;
    }
}

//1.定义一个自己的MyInvocationHandler
class MyInvocationHandler implements InvocationHandler {

    private Object helloService;
    private Object helloService1;

    MyInvocationHandler(Object helloService1){
        this.helloService = helloService;
        this.helloService1=helloService1;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result1 = new HelloServiceImpl();
        if(true){
            return method.invoke(helloService1,args);
        }else if(false){
           return method.invoke("hello",args);
        }else{
            return method.invoke(new ArrayList<>(),args);
        }
    }
}


