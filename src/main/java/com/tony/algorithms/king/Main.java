package com.tony.algorithms.king;

import java.util.Scanner;



public class Main {
    //500 3
    //100 200
    //150 300
    //360 361
    public static void main(String[] args) {
        int M = 0, N = 0,last = 0;
        int i,n;
        int[] deng = new int[10001]; 
        Scanner in = new Scanner(System.in);
        int start = 0, end = 0;
        while (in.hasNext()) {
            M = in.nextInt();// 输入马路长度
            N = in.nextInt();// 输入区域的数目
//            System.out.println(M);
//            System.out.println(N);
            if((1<=M||M<=10000)&&(1<=N||N<=100)){
                for(i=0;i<=M;i++)
                    deng[i]=1;
            }
            for (i = 0; i < N; i++) {
                start = in.nextInt();
                end = in.nextInt();
                for(n=start;n<=end;n++)
                    deng[n]=0;
            }
            for(i=0;i<=M;i++){
                if(deng[i]!=0)
                  last++;
            }
            System.out.println(last);
        }
    }
}
