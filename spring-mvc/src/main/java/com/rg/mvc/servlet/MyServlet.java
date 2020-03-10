package com.rg.mvc.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mvc.servlet 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月06日17:30   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@WebServlet(urlPatterns = "/myServlet/*")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogic(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogic(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init method");
    }

    private void handleLogic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("handle myLogic");
        ServletContext sc = getServletContext();
        /*RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");

        rd.forward(req, resp);*/
        resp.getWriter().print("hello warrior");
    }
}
