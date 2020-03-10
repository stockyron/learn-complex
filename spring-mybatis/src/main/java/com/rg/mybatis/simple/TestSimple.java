package com.rg.mybatis.simple;

import com.rg.mybatis.User;
import com.rg.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.annotations.Test;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mybatis.simple 
 *  * @Description: TODO   测试独立使用mybatis
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月03日12:15   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class TestSimple {

    static SqlSessionFactory sqlSessionFactory;
    static {
        sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User u = new User();
            u.setName("赵六");
            u.setAge(33);
            userMapper.insertUser(u);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.getUser(1));
        } finally {
            sqlSession.close();
        }
    }

}
