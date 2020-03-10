package com.rg.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日18:16   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* com.rg.aop.*.test(..))")
    private void test(){}

    @Before("test()")
    private void beforeTest(){
        System.out.println("beforeTest");
    }

    @After("test()")
    private void afterTest(){
        System.out.println("afterTest");
    }

    @Around("test()")
    private Object aroundTest(ProceedingJoinPoint p){
        System.out.println("around before");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around after");
        return o;
    }

}
