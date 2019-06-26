package com.oyoungy;

import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) {
        int[] a = {5,6,7,7,8,1,2};
        Solution ans = new Solution();
        System.out.println(ans.minNumberInRotateArray(a));
        System.out.println(ans.minNumberInRotateArray(new int[]{5,6,7,7,8,1,2,3,4,5,5}));
    }
    public int minNumberInRotateArray(int [] array) { //二分法
        int len = array.length;
        if(len==0) return 0;
        int low =0, high = len-1;
        while (low<high && array[high]<=array[low]){
            int mid = low+(high-low)/2;
            if(array[mid]>array[low]){
                low = mid+1;
            }else if(array[mid]<array[low]){
                high = mid;
            }else{   //中间临界条件需要额外判断
                if(array[mid]>=high){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
        }
        return array[low];
    }
}