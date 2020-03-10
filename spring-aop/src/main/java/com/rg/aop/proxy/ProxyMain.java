package com.rg.aop.proxy;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.proxy 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日19:47   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ProxyMain {

    public static void main(String[] args) {
        ProxySaler proxySaler = new ProxySaler();
        Person person = (Person) proxySaler.newInstall(new XiaoQiong("黄浩强", "南山区"));
        person.buy();
        person.buy1();
    }

}
