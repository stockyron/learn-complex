package com.rg.mvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mvc.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月04日19:49   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Controller
public class UserController {

    @GetMapping("hello")
    @ResponseBody
    public Object hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "hello world";
    }

    @GetMapping("userList.htm")
    public Object get(ModelAndView model) throws Exception {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUsername("张三");
        user.setAge(10);
        list.add(user);

        User user1 = new User();
        user1.setUsername("李四");
        user1.setAge(20);
        list.add(user1);
        model.addObject("users", list);
        /*return "userList";*/ //为啥读不到users
        model.setViewName("userList");
        return model;
    }

    /*protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUsername("张三");
        user.setAge(10);
        list.add(user);

        User user1 = new User();
        user1.setUsername("李四");
        user1.setAge(20);
        list.add(user1);

        return new ModelAndView("user", "users", list);
    }*/
}
