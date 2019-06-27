package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.JumpFloor(2));
        System.out.println(ans.JumpFloor(3));
        System.out.println(ans.JumpFloor(5));
    }
    public int JumpFloor(int target) {  //思路：Fibonacci数列 f(n) = f(n-1) + f(n-2)
        int f1 = 0, f2 = 1, temp;
        while (target-->0){
            temp = f2;
            f2 = f1+f2;
            f1 = temp;
        }
        return f2;
    }
}
