package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.NumberOf1Between1AndN_Solution(13));
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<0) return 0;
        int sum = 0;
        for(int i=0; i<=n; i++){
            sum+=numberOf1InN(i);
        }
        return sum;
    }
    private int numberOf1InN(int n){
        int count=0;
        while (n!=0){
            if(n%10==1){
                count++;
            }
            n=n/10;
        }
        return count;
    }
}