package com.rg.bean.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.proxy 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月22日10:35   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ProxyUtils {

    public static <T> T createProxy(final T obj) {

        final InvocationHandler handler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                System.out.printf("About to call %s() on %s\n", method
                        .getName(), obj);
                return method.invoke(obj, args);
            }
        };

        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
                .getClass().getInterfaces(), handler);
    }


}
