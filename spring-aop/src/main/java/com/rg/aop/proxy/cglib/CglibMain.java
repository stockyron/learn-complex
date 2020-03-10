package com.rg.aop.proxy.cglib;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.proxy.cglib 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日20:02   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class CglibMain {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        PlayGame playGame = (PlayGame) cglibProxy.newInstall(new PlayGame("a"));
        playGame.play("小明");
    }

}
