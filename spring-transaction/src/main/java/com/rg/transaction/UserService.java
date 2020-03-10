package com.rg.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.transaction 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月03日17:37   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public interface UserService {

    void save(User user) throws Exception;

}
