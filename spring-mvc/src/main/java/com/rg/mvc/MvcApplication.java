package com.rg.mvc;

import com.rg.mvc.servlet.MyServlet;
import com.rg.mvc.simple.MyDataContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;


@SpringBootApplication
@ServletComponentScan
public class MvcApplication {

    /*@Bean  用@ServletComponentScan、@WebServlet(urlPatterns = "/myServlet/*")注解代替
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet());
    }*/

    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(MvcApplication.class, args);
        /*ac.publishEvent(new MyDataContextListener());
        ac.close();*/
    }

}
