package com.rg.bean.circleReference;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.circleReference 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月24日14:53   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class CircleTest {

    //没有debug到具体的报错位置，循环依赖问题留下：
    //www.iflym.com/index.php/code/201208280001.html
    public static void main(String[] args) throws Throwable {
        try {
            new ClassPathXmlApplicationContext("circle-bean.xml");
        } catch (Exception e) {
            e.printStackTrace();//要在创建C的时候抛异常
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

}
