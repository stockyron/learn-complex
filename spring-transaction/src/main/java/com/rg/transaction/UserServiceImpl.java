package com.rg.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Types;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.transaction 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月03日17:38   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class UserServiceImpl implements UserService{

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) throws Exception {
        jdbcTemplate.update("insert into user(name,age,sex) value (?,?,?)",
                new Object[]{ user.getName(), user.getAge(), user.getSex()},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
        throw new RuntimeException("aa");
    }

}
