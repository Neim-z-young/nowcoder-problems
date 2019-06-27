package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.RectCover(4));
    }
    public int RectCover(int target) {  //规律：竖着表示占两格，横着表示占一格；也是Fibonacci
        if(target==0) return 0;
        int f1=0, f2=1, temp=0;
        while (target-->0){
            temp = f2;
            f2 = f1+f2;
            f1 = temp;
        }
        return f2;
    }
}
