package proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibPro implements MethodInterceptor {

    public Object getInstance(Class clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object res = methodProxy.invokeSuper(o, objects);
        after();
        return res;
    }

    public void before(){
        System.out.println("前置方法");
    }

    public void after(){
        System.out.println("后置方法");
    }
}
