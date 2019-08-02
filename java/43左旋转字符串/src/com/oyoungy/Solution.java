package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.LeftRotateString("asdsff", 0));
        System.out.println(ans.LeftRotateString("asdsff", 1));
    }

    /**
     * 输入(asdaffas,  3)  拆分为asd affas  =>  affas+asd
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if(str==null || str.length()==0) return "";
        n%=str.length();  //字符串分隔的下标
        return str.substring(n, str.length())+str.substring(0, n);
    }
}