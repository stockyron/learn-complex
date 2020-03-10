package com.rg.jdbc;

import lombok.Data;
import java.util.Date;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author horus
 * @since 2019-12-06
 */
@Data
public class User {

    private int id;
    private String name;
    private int age;
    private String sex;


}
