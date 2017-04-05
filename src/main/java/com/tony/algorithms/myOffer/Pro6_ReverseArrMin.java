package com.tony.algorithms.myOffer;

/**
 * 类Pro6_ReverseArrMin.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月20日 下午2:45:13
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class Pro6_ReverseArrMin {
    public static void main(String[] args) {
//        int[] test = {3,4,5,1,2};
        int[] test = null;
        System.out.println(minNumberInRotateArray(test));
    }
    
    public static int minNumberInRotateArray(int[] array) {
        if(array==null || array.length == 0){
            return 0;
        }
        
        int low = 0;
        int high = array.length-1;
        int mid = low;
        
        while(array[low]>=array[high]){
            if(high - low == 1){
                mid = high;
                break;
            }
            mid = (low+high)/2;
            //特殊情况。如果low，mid，high三个数相等，只能顺序查找
            if(array[low] == array[mid] &&  array[mid]==array[high]){
                return minInOrder(array,low,high);
            }
            //如果中间值大于左边，则最小值肯定在右边
            if(array[mid] >= array[low]){
                low = mid;
            }else if(array[mid] <= array[high]){
                high = mid;
            }
        }
        return array[mid];
    }

    private static int minInOrder(int[] array, int low, int high) {
        int result = array[low];
        for(int i=low+1;i<=high;i++){
            if(result > array[i]){
                result = array[i];
            }
        }
        return result;
    }
}
