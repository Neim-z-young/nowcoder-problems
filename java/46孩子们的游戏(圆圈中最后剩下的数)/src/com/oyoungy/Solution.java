package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.LastRemaining_Solution(5, 3));
    }

    /**
     * 动态规划法
     * n=5, m=3时
     *  0 1 2 3 4  去掉2   新的序列从3开始（0,...,m-1)，新下标与旧下标的变换公式为oldInx = (newIndex+m)%n
     *  0 1   3 4  去掉0   ans新下标为0
     *    1   3 4  去掉4   ans新下标为1
     *    1   3    去掉1   ans新下标为1
     *        3            ans新下标为0，对应上一层的下标为(0+3)%2 = 1，以此类推求出n=5,m=3时最后剩余的元素下标
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n==0) return -1;
        int s=0;
        for(int i=2; i<=n; i++){
            s = (s+m)%i;
        }
        return s;
    }
}