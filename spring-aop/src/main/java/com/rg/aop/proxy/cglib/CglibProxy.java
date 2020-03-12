package com.rg.aop.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.proxy.cglib 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日19:58   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {

    public Object newInstall(Object object) {
        return Enhancer.create(object.getClass(), this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("先热身一会");
        methodProxy.invokeSuper(o, objects);
        System.out.println("打完了");
        return null;
    }


}
