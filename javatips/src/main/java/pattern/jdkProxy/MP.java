package pattern.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MP implements InvocationHandler {
    private IPerson target;

    public IPerson getInstance(IPerson target){
        this.target = target;
        Class<? extends IPerson> clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object res = method.invoke(this.target, args);
        after();
        return res;
    }

    private void before(){
        System.out.println("before...");
    }

    private void after(){
        System.out.println("after...");
    }
}
