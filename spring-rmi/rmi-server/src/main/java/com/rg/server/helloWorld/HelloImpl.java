package com.rg.server.helloWorld;

import com.rg.common.dto.User;
import com.rg.common.interfaces.IHello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.server 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月07日19:38   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

    /**
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，必须声明抛出RemoteException异常
     *
     * @throws RemoteException
     */
    public HelloImpl() throws RemoteException {
    }

    public User updateUser(User user) throws RemoteException {
        System.out.println("-------------- 客户端发送的user为" + user.toString());
        user.setName("andy2323");
        user.setAge(40);
        return user;
    }

}
