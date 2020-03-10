package com.rg.mybatis.simple;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mybatis.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月03日12:11   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class MybatisUtil {

    private final static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";

        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
