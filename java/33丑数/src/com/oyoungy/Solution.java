package com.oyoungy;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.GetUglyNumber_Solution(5));
        System.out.println(ans.GetUglyNumber_Solution(1));
        System.out.println(ans.GetUglyNumber_Solution(11));
    }
    /**
     * p=2^x * 3^y * 5^z
     * 三队列思想
     */
    public int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(index<=0) return 0;
        int p2 = 0, p3 = 0, p5 = 0, newNum = 1;
        ans.add(newNum);
        while (--index>0){
            newNum = findMin(ans.get(p2)*2, ans.get(p3)*3, ans.get(p5)*5);
            //三个条件判断去重复
            if(newNum==ans.get(p2)*2) p2++;
            if(newNum==ans.get(p3)*3) p3++;
            if(newNum==ans.get(p5)*5) p5++;
            ans.add(newNum);
        }
        return ans.get(ans.size()-1);
    }

    int findMin(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }

    /***
     * 动规法或暴力法都不行
     */
    private boolean ugly[];

    public int GetUglyNumber_Solution1(int index) {
        //动规法所需的最大空间太大了
        int maxLength = Integer.MAX_VALUE/5;
        if(index<=maxLength){
            maxLength = index;
        }
        maxLength = maxLength*5 + 1;
        ugly = new boolean[maxLength];
        for(int i = 1; i<ugly.length; i++){
            ugly[i] = isUglyDP(i);
        }
        int ans = 1;
        while (index!=0){
            if(ugly[ans++]){
                index--;
            }
        }
        return --ans;
    }

    //动态规划
    boolean isUglyDP(int n){
        if(n<0) return false;
        if(n==1 || n==2 || n==3 || n==5) return true;
        if(ugly[n]) return true;
        int prime[] = {2,3,5};
        int i=0, divided = 0;
        for (; i < prime.length; i++) {
            divided = n / prime[i];
            if (divided * prime[i] == n) {  //判断整除
                ugly[n] = isUglyDP(divided);
                break;
            }
        }
        return ugly[n];  //不能整除时输出false
    }


    //逐一判断的效率太低了
    boolean isUgly(int n){
        if(n<0) return false;
        int prime[] = {2,3,5};
        while (n!=1){
            int i=0;
            for(; i<prime.length; i++){
                int divided = n/prime[i];
                if(divided*prime[i]==n){  //判断整除
                   n = divided;
                   break;
                }
            }
            if(i==prime.length){
                return false;
            }
        }
        return true;
    }
}