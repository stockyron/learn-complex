package com.rg.lock.type;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.type 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月17日16:58   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class TypeParameterTest<T extends CharSequence> {

    public static void main(String[] args) {
        Class<TypeParameterTest> clz = TypeParameterTest.class;
        TypeVariable<Class<TypeParameterTest>>[] t = clz.getTypeParameters();
        for(TypeVariable<Class<TypeParameterTest>> m : t) {
            /**
             * 获得类型变量在声明的时候的名称，此例中为T
             */
            System.out.println(m.getName());//T
            /**
             * 获得类型变量的上边界，若无显式的定义（extends）,默认为Object;类型变量的上边界可能不止一个，
             * 因为可以用&符号限定多个（这其中有且只能有一个为类或抽象类，且必须放在extends后的第一个，
             * 即若有多个上边界，则第一个&后必须为接口）
             *
             */
            Type[] bounds = m.getBounds();
            for(Type t1 : bounds) {
                System.out.println(t1);//common java.lang.CharSequence
            }
            /**
             * 获得声明这个类型变量的类型及名称
             * 类中：class reflect.TypeParameterTest
             */
            System.out.println(m.getGenericDeclaration());//class com.rg.lock.type.TypeParameterTest
        }
        Type genericSuperclass = clz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        System.out.println(clz.getSuperclass());
    }

}
