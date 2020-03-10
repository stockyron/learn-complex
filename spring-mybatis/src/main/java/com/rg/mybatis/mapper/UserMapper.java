package com.rg.mybatis.mapper;

import com.rg.mybatis.User;

import java.util.List;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mybatis.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月03日12:05   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public interface UserMapper {

    void insertUser(User user);

    User getUser(int id);

}
