package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length==0) return 0;
        int maxSum = array[0], continuousSum = maxSum;
        for(int i=1; i<array.length; i++){
            continuousSum = continuousSum+array[i];
            if(continuousSum>0){
                if(continuousSum>maxSum){
                    maxSum = continuousSum;
                }
            }else {
                if(continuousSum>maxSum){
                    maxSum = continuousSum;
                }
                continuousSum = 0;
            }
        }
        return maxSum;
    }
}