package com.rg.lock.byteTest;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.byteTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月14日13:15   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class b {


    public static void main(String[] args) {
        //???????
        int aaa = 29;
        System.out.println("二进制 ~aaa = " + Integer.toBinaryString(~aaa));
        System.out.println("二进制 1 = " + Integer.toBinaryString(1 ));
        System.out.println("二进制 1 & ~aaa = " + Integer.toBinaryString(1 & ~aaa));
        System.out.println("二进制 2 = " + Integer.toBinaryString(2 ));
        System.out.println("二进制 2 & ~aaa = " + Integer.toBinaryString(2 & ~aaa));

        //按位与 按位或 按位异或
        System.out.println((1 & 1) + "------" + (1 | 1) + "------" + (1 ^ 1));
        System.out.println((1 & 2) + "------" + (1 | 2) + "------" + (1 ^ 2));
        System.out.println((1 & 3) + "------" + (1 | 3) + "------" + (1 ^ 3));
        System.out.println((1 & 4) + "------" + (1 | 4) + "------" + (1 ^ 4));
        System.out.println((1 & 5) + "------" + (1 | 5) + "------" + (1 ^ 5));
        System.out.println("-----------------------------------------------");
        System.out.println((2 & 1) + "------" + (2 | 1) + "------" + (2 ^ 1));
        System.out.println((2 & 2) + "------" + (2 | 2) + "------" + (2 ^ 2));
        System.out.println((2 & 3) + "------" + (2 | 3) + "------" + (2 ^ 3));
        System.out.println((2 & 4) + "------" + (2 | 4) + "------" + (2 ^ 4));
        System.out.println((2 & 5) + "------" + (2 | 5) + "------" + (2 ^ 5));
        System.out.println("-----------------------------------------------");
        System.out.println((3 & 1) + "------" + (3 | 1) + "------" + (3 ^ 1));
        System.out.println((3 & 2) + "------" + (3 | 2) + "------" + (3 ^ 2));
        System.out.println((3 & 3) + "------" + (3 | 3) + "------" + (3 ^ 3));
        System.out.println((3 & 4) + "------" + (3 | 4) + "------" + (3 ^ 4));
        System.out.println((3 & 5) + "------" + (3 | 5) + "------" + (3 ^ 5));

    }


    //检查ArrayList是否具有偶数个索引(这是必需的)
    private static boolean isEven(int number){
        return (number & 1) == 0;
    }

}
