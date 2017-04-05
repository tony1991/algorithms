package com.tony.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {
    public static void main(String[] args) throws IOException {
        countWordInFile("","");
    }
    
    /**
     * 统计给定文件中给定字符串的出现次数
     * @param filename  文件名
     * @param word 字符串
     * @return 字符串在文件中出现的次数
     */
    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    }
}
