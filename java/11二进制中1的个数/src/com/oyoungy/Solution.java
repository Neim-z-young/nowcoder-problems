package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.NumberOf1(5));
        System.out.println(ans.NumberOf1(-5));
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0){    // 移位操作
            count += Math.abs(n%2);
            n=n>>>1;
        }

//        while(n!= 0){   //巧妙的方法
//            count++;
//            n = n & (n - 1);
//        }
        return count;
    }
}