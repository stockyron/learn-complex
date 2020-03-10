package com.rg.common.interfaces;

import com.rg.common.dto.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

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
public interface IHello extends Remote {

    /**
     * 更新user信息
     * @param user
     * @return
     * @throws RemoteException
     */
    User updateUser(User user) throws RemoteException;


}
