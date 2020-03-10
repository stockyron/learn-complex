package com.rg.server.simple;

import com.rg.common.interfaces.HelloRMIService;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.rmi 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月07日19:04   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class HelloRMIServiceImpl implements HelloRMIService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return Math.abs(a - b);
    }

}
