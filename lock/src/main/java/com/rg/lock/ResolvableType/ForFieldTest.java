package com.rg.lock.ResolvableType;

import lombok.Data;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.ResolvableType 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月17日18:55   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ForFieldTest {

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = Fields.class.getDeclaredField("charSequenceList");
        ResolvableType type = ResolvableType.forField(field);
        System.out.println(type.getType());
    }

    @Data
    class Fields{
        private List<String> charSequenceList;
    }

}
