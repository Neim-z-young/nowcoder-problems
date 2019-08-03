package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.Sum_Solution(3));
    }

    /**
     * 不能循环则采用递归法
     * 不能使用if则通过&&运算的特性进行if判断
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean bool = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}