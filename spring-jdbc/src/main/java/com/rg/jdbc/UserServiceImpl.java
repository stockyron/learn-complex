package com.rg.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jdbc 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月02日18:18   
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
    public void save(User user) {
        jdbcTemplate.update("insert into user(name,age,sex)values(?,?,?)",
                new Object[]{ user.getName(), user.getAge(), user.getSex()},
                new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR}
                );
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from user", new UserRowMapper());
//        return jdbcTemplate.query("select * from user where age=?",
//                new Object[]{20}, new int[]{Types.INTEGER}, new UserRowMapper());
    }

}
