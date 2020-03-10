package com.rg.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jdbc 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月02日18:10   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setSex(resultSet.getString("sex"));
        return user;
    }

}
