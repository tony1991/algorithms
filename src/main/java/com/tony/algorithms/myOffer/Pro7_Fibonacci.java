package com.tony.algorithms.myOffer;

/**
 * 类Pro7_Fibonacci.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月20日 下午3:04:10
 * 要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Pro7_Fibonacci {
    
    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
    
    public static int Fibonacci(int n) {
        if(n < 0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fibNumOne = 0;
        int fibNumTwo = 1;
        int fibN = 0;
        for(int i=2;i<=n;i++){
            fibN = fibNumOne + fibNumTwo;
            fibNumOne = fibNumTwo;
            fibNumTwo = fibN;
        }
        return fibN;
//        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
