package com.rg.aop.proxy.cglib;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.proxy.cglib 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日20:00   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class PlayGame {

    //必须要有无参构造器
    public PlayGame() {}

    public PlayGame(String a) {
    }

    public void play(String name){
        System.out.println(name + " 打篮球很厉害");
    }

}
