package com.rg.aop.declareParents;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.declareParents 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月01日17:07   
 *  * @Version:   v1.0
 *  *    
 *  该类的目的是为了能在spring容器中能注入已装载的Bean.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AnnotationConfig {
}
