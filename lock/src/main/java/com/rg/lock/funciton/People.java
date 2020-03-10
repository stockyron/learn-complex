package com.rg.lock.funciton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.funciton 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日17:10   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
public class People {

    private Integer age;
    private String name;
    private int salary;

    public People() {
    }

    public People(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public People(Integer age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
}
