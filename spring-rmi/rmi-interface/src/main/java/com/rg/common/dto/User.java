package com.rg.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.server 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月07日19:35   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
public class User implements Serializable {

    private String name;

    private int age;

}
