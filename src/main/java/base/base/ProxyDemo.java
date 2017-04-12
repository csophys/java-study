package base.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by csophys on 16/10/18.
 */
public class ProxyDemo {


    // Object result = method.invoke(helloService,args);
    // Proxy.newProxyInstance返回的是helloService的实例

    public static void main(String[] args) {
        //1. 真实的示例引用
        HelloService helloService = new HelloServiceImpl();
        //2. 创建代理类实例
        HelloService result = (HelloService)Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{HelloService.class}, new MyInvocationHandler(helloService));
        //3. 调用方法
        System.out.println(result.hello("csophys"));

        HelloService proxy = getProxy(HelloService.class,helloService);
        System.out.println(proxy);
    }

    public static <T> T getProxy(Class<T> targetClass,T target){
        T t = (T) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(),new Class[]{targetClass},new MyInvocationHandler(target));
        return t;
    }
}

//1.定义一个自己的MyInvocationHandler
class MyInvocationHandler implements InvocationHandler {

    private Object helloService;

    MyInvocationHandler(Object helloService){
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result = method.invoke(helloService,args);
        System.out.println("after invoke");
        return result;
    }
}


