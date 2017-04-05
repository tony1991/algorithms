package com.tony.algorithms;

/*
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
*/      
public class Matrix2D {
    
    /**
     * 从右上角遍历
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {  
        if(matrix.length==0 || matrix[0].length == 0){
            return false;
        }
        int i=0;
        int j = matrix[0].length-1; //从右上角开始
        while(i<matrix.length && j>=0){
            int x = matrix[i][j];
            if(target == x) return true;
            else if (target < x) --j;
            else ++i;
        }
        return false;
    }
}
