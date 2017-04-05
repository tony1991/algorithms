package com.tony.algorithms.myOffer;

public class Pro10_Count1 {
    public static void main(String[] args) {
        //使用n=10,二进制形式为1010，则1的个数为2；
        int n = 10;
        System.out.println(n + "的二进制中1的个数：" + NumberOf1(n));
        int[] list = {1,2,3,6,7,8,12,4};
        get2Number(list);
        getChangeNumber(10,13);
    }
    
    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n & flag)!=0){
                count++;
            }
            flag = flag <<1;
        }
        return count;
    }
    
    public static int BestNumberOf1(int n){
        int count = 0;
        while(n!=0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
    
    public static void get2Number(int[] list){
        System.out.print("list中2的整数倍的数为：");
        for(int i=0;i<list.length;i++){
            if((list[i] & list[i]-1)==0){
                System.out.print(list[i]);
            }
        }
        System.out.println();
    }
    
    public static void getChangeNumber(int m,int n){
        int orResult = m ^ n ;
        int number = BestNumberOf1(orResult);
        System.out.print("改变m二进制中的"+number+"位可以得到n");
    }
}
