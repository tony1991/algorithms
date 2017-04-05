package com.tony.algorithms;

public class Reverse {
	public static void main(String[] args) {
		String str = "hi welcome to mogujie";
		
		String[] strArray = str.split(" ");
		for(int i = strArray.length;i>0;i--){
			System.out.print(strArray[i-1]+" "); 
		}
	}
	
	public static String reverseWordOne(String word){
		StringBuffer sb = new StringBuffer(word); 
		word = sb.reverse().toString();
		return word;
	}
	
	public static void reverseWordTwo(String word){
        for (int i = word.length(); i > 0; i--) { 
            System.out.print(word.charAt(i - 1)); 
        } 
	}
}
