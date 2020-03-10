package com.rg.aop.declareParents;

import org.springframework.stereotype.Component;

/**
 * @author bill
 */
@Component
public class Man {

    protected void likeGirl(){
        System.out.println("================ 喜欢女孩");
    }

}
