package com.rg.client.helloWorld;


import com.rg.common.dto.User;
import com.rg.common.interfaces.IHello;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.client 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月07日19:49   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class HelloClient {

    public static void main(String[] args) {
        try {
            // 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
            IHello rhello = (IHello) Naming.lookup("rmi://localhost:8888/IHello");
            // 构造user对象，测试远程对象传输
            User user = new User();
            user.setAge(20);
            user.setName("andy");
            System.out.println(Arrays.asList(Naming.list("rmi://localhost:8888/IHello")));
            System.out.println("-------------- 服务端返回的的user为" + rhello.updateUser(user).toString());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
