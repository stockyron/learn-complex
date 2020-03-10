package com.rg.aop.declareParents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.declareParents 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月01日17:08   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class DeclareParentsMain {

    public static void main(String[] args) {
        //AnnotationConfig 是 注解形式加载类 @Configuration 注解
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Person person = (Person) ctx.getBean("women");
        person.likePerson();
        Animal animal = (Animal)person;
        animal.eat();

        Man man = (Man) ctx.getBean("man");
        man.likeGirl();
    }

}
