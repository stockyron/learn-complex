package com.rg.jdbc;

import java.util.List;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jdbc 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月02日18:16   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public interface UserService {

    void save(User user);

    List<User> getUsers();

}
