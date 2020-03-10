package com.rg.aop.intervalTransaction;

import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.intervalTransaction 
 *  * @Description: TODO 
 */
public class AServiceImpl implements AService{

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void a() {
        ((AService)AopContext.currentProxy()).b();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void b() {

    }
}
