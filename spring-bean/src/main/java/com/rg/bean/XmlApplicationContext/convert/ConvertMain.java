package com.rg.bean.XmlApplicationContext.convert;

import javafx.util.converter.DefaultStringConverter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.XmlApplicationContext.convert 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日15:14   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ConvertMain {

    public static void main(String[] args) {
        DefaultConversionService converter = new DefaultConversionService();
        converter.addConverter(new String2DateConvert());

        System.out.println(converter.convert("2019-12-31 11:11:12", Date.class));
    }

}
