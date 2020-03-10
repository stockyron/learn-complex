package com.rg.netty.custom.server.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty.custom.server.dto 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月27日15:17   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
public class OnlineCustomDto implements Serializable {

    private String customId;

    private String name;

}
