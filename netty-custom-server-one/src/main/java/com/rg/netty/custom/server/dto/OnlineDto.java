package com.rg.netty.custom.server.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty.custom.server 
 *  * @Description: TODO 客服上线返回dto   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月27日15:15   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
public class OnlineDto implements Serializable {

    //客服唯一识别id
    private String serverId;

    //在线会员列表信息
    private List<OnlineCustomDto> list;
}
