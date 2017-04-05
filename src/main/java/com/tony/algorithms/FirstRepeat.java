package com.tony.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 类FirstRepeat.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月10日 下午4:25:58
 * 
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
测试样例：
"qywyer23tdd",11
返回：y
 */
public class FirstRepeat {
    public static void main(String[] args) {
        char result = findFirstRepeat("qywyer23tdd",11);
        System.out.println(result);
    }
    
    public static char findFirstRepeat(String A, int n) {
        char[] charArray = A.toCharArray();
        char result = charArray[0];
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        for(int i=0;i<charArray.length;i++){
            if(charMap.get(charArray[i])==null){
                charMap.put(charArray[i], 1);
            }else{//出现重复，后面不用执行了
                /*
                int count = charMap.get(charArray[i]);
                charMap.put(charArray[i], count);
                */
                result = charArray[i];
                break;
            }
        }
        return result;
    }
}
