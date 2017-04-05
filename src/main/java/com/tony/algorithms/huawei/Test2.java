package com.tony.algorithms.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MyComparator implements Comparator<String>{
    Map<String, Integer> map;
    
    public MyComparator(Map<String, Integer> recordMap) {
        this.map = recordMap;
    }

    @Override
    public int compare(String str1, String str2) {
        if(!map.containsKey(str1) || !map.containsKey(str2)){
            return 0;
        }
        //按降序排列
        if(map.get(str1)<map.get(str2)){
            return 1;
        }else{
            return -1;//相等也要返回-1，否则在排序时不会把相等的值放到TreeMap中，若=0则新值替代原值
            //数目相同的情况下，按照输入第一次出现顺序排序
        }
    }
}

public class Test2 {

    public static void main(String[] args) {
        Map<String, Integer> recordMap = new HashMap<String, Integer>();
        // 输入
        String file;
        int errorLine;
        int lastIndex = 0;
        String recName = null;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            file = sc.next();
            errorLine = sc.nextInt();
            // 解析获得文件名
            lastIndex = file.lastIndexOf("\\");// 获取最后一个'\'的索引
            recName = (lastIndex < 0) ? file : file.substring(lastIndex + 1) + " " + errorLine;
            int count = 0;
            if (recordMap.containsKey(recName)) {
                count = recordMap.get(recName);
                recordMap.put(recName, ++count);
            } else {
                recordMap.put(recName, 1);
            }
        }
        sc.close();
        // 排序输出
        orderPrint(recordMap);
    }

    private static void orderPrint(Map<String, Integer> recordMap) {
        ArrayList<String> keys = new ArrayList<String>(recordMap.keySet());
        MyComparator bvc = new MyComparator(recordMap);
        int lastIndex = 0;
        Collections.sort(keys, bvc);
        //如果超过8条记录，则只输出前8条记录.
        for (int i = 0; i < (keys.size() > 8 ? 8 : keys.size()); i++) {
            String key = keys.get(i);
            StringBuilder res = new StringBuilder();
            lastIndex = key.lastIndexOf(" ");
            int value = recordMap.get(key);
            if (lastIndex > 16) {
                res.append(key.substring(lastIndex - 16));
            } else {
                res.append(key);
            }
            res.append(" " + value);
            System.out.println(res.toString());
        }
    }
}
