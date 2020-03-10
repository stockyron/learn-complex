package com.rg.netty.server.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty.controller 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月27日13:51   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
public class WsMassage<T> implements Serializable {

    public final static String TYPE_SERVER_ONLINE = "1";


    public final static String SYSYTEM_CODE_CALL_CENTER = "CC";
    //消息类型
    private String type;
    //系统标识
    private String systemCode;
    //连接用户标识
    private String userCode;
    //接收标识
    private String callCenterCode;

    //消息体
    private T data;
}
