package com.rg.bean.objectPrviderTest;

import com.rg.bean.config.MyBeanPostProcessor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.objectPrviderTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月17日19:30   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Service
public class Test1 {

    private final MyBeanPostProcessor repository;

    public Test1(ObjectProvider<MyBeanPostProcessor> repositoryProvider) {
        this.repository = repositoryProvider.getIfUnique();
    }



}
