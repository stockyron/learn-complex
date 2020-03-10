package com.rg.lock.byteTest;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.byteTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月14日12:18   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class a {

    //正数负数左移<<都是乘以2的n次方，
    // 右移能除尽就是除的结果，
    // 不能除尽正数就是程序的除法的结果，负数则要转换了计算
    public static void main(String[] args) {
        int a = 13;
        System.out.println("TimerTest = " + Integer.toBinaryString(a));

        int b = a << 2;
        System.out.println("b = " + Integer.toBinaryString(b));
        System.out.println(b);

        int b1 = a >> 2;
        System.out.println("b1 = " + Integer.toBinaryString(b1));
        System.out.println(b1);

        System.out.println("----------------------------------------------");

        int c = -13;
        System.out.println("c = " + Integer.toBinaryString(c));

        int d = c << 2;
        System.out.println("d = " + Integer.toBinaryString(d));
        System.out.println(d);

        int e = c >> 2;
        System.out.println("e = " + Integer.toBinaryString(e));
        System.out.println(e);

        int f = c >>> 1;
        System.out.println("f = " + Integer.toBinaryString(f));
        System.out.println(f);

        int aa = Integer.SIZE - 3;
        int bb = -1 << aa;
        System.out.println("bb = " + Integer.toBinaryString(bb));
        System.out.println("bb = " + bb);

        int cc = 0 << aa;
        System.out.println("cc = " + Integer.toBinaryString(cc));
        System.out.println("cc = " + cc);

        int dd = 1 << aa;
        System.out.println("dd = " + Integer.toBinaryString(dd));
        System.out.println("dd = " + dd);

        int ee = 2 << aa;
        System.out.println("ee = " + Integer.toBinaryString(ee));
        System.out.println("ee = " + ee);

        int ff = 3 << aa;
        System.out.println("ff = " + Integer.toBinaryString(ff));
        System.out.println("ff = " + ff);
    }

}
