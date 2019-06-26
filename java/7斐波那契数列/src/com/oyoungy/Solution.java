package com.oyoungy;

public class Solution {
    public int Fibonacci(int n) {
        if(n==0) return 0;
        int f1=0, f2=1, temp;
        while (--n>0){
            temp = f2;
            f2 = f1+f2;
            f1 = temp;
        }
        return f2;
    }
}
