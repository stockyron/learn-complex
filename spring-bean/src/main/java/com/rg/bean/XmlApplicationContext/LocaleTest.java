package com.rg.bean.XmlApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.XmlApplicationContext 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日13:15   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class LocaleTest {

    /*public static void main(String[] args) {
        //信息格式化串
        String pattern1 = "{0},你好！你于{1}在工商银行存入{2}元。";
        String pattern2 = "At {1,time,short} On{1,date,long}, {0} paid {2,number,currency}.";

        //用于动态替换占位符的参数
        Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};

        //使用默认本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1, params);
        System.out.println(msg1);//John,你好！你于19-12-31 下午1:23在工商银行存入1,000元。

        //使用指定的本地化对象格式化信息
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg2);//At 1:23 PM OnDecember 31, 2019, John paid $1,000.00.
    }*/


    /*public static void main(String[] args) {
        String[] configs = {"applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        //直接通过容器访问国际化信息
        Object[] params = {"John", new GregorianCalendar().getTime()};
        //结果不对啊？？？
        //读messages.properties,默认的英文，等于messages_en_US.properties
        System.out.println(ctx.getMessage("test", params, Locale.US));
        System.out.println(ctx.getMessage("test", params, Locale.CHINA));

    }*/

    //。。。
    public static void main(String[] args) {
        // 返回Java所支持的全部国家和语言的数组
        Locale[] localeList = Locale.getAvailableLocales();
        // 遍历数组的每个元素，依次获取所支持的国家和语言
        for (int i = 0; i < localeList.length; i++) {
            System.out.println("===================start");
            //            // 打印出所支持的国家和语言
            System.out.println(localeList[i].getDisplayCountry() + "=" + localeList[i].getCountry() + " "
                    + localeList[i].getDisplayLanguage()
                    + "=" + localeList[i].getLanguage());

            // 取得系统默认的国家/语言环境
            Locale myLocale = Locale.getDefault();
            // 根据指定国家/语言环境加载资源文件
            ResourceBundle bundle = ResourceBundle.getBundle("messages", myLocale);
            // 打印从资源文件中取得的消息
            System.out.println(bundle.getString("customer.name.label.default"));
            System.out.println("===================end");
        }
    }


}