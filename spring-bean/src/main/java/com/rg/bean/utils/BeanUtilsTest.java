package com.rg.bean.utils;

import lombok.Data;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.BeanUtils;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.utils 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月22日19:28   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class BeanUtilsTest {

    public static void main(String[] args) throws Exception {
        A a = BeanUtilsTest.newInstance(A.class);
        a.setName("aa");
        a.setAge(20);
        a.setSalary(5000);

        B b = BeanUtilsTest.newInstance(B.class);
        BeanUtils.copyProperties(a, b);

        System.out.println(b);

    }


    private static <T> T newInstance(Class<T> clz) throws Exception {
        return clz.newInstance();
    }

    @Data
    public static class A{
        private String name;
        private int age;
        private long salary;

    }

    @Data
    public static class B{
        private String name;
        private int age;
        private String address;

    }

}
