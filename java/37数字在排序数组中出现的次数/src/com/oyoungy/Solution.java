package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    //二分法查找出现次数
    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length==0) return 0;
        int inx = BinaryFind(array, k, 0, array.length);
        if(inx==-1) return 0;
        int count =0, lower = inx, higher = inx+1;
        while (lower>=0 && array[lower]==k){
            lower--;
            count++;
        }
        while (higher<array.length && array[higher]==k){
            higher++;
            count++;
        }
        return count;
    }
    private int BinaryFind(int [] array, int k, int low, int high){
        if(low == high-1 && array[low]!=k) return -1;
        int mid = low + (high-low)/2;
        if(array[mid]==k){
            return mid;
        }else if(k<array[mid]){
            return BinaryFind(array, k, low, mid);
        }else {
            return BinaryFind(array, k, mid, high);
        }
    }
}