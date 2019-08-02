package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.ReverseSentence("student. a am I"));
        System.out.println(ans.ReverseSentence(" "));
    }
    public String ReverseSentence(String str) {
        String[] strs = str.split("\\s+");
        if(strs.length==0) return str;
        String ans = "";
        for(int i=strs.length-1; i>=0; i--){
            ans+=strs[i];
            if(i!=0){
                ans+=" ";
            }
        }
        return ans;
    }
}