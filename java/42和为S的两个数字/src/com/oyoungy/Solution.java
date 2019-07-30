package com.oyoungy;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    //双指针
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(array==null || array.length==0) return ans;
        int first = 0, last = array.length-1;
        while (first!=last && first<array.length && last>=0){
            int remain = sum-array[first];
            if(remain==array[last]){
                ans.add(array[first]);
                ans.add(array[last]);
                break;
            }else if(remain<array[last]){
                last--;
            }else if(remain>array[last]){
                first++;
            }
        }
        return ans;
    }
}