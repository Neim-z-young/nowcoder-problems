package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.replaceSpace(new StringBuffer("sdsd das  d")));
    }
    public String replaceSpace(StringBuffer str) {
        int len = str.length();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<len; i++)
        {
            if(str.charAt(i)==' ') //直接append
                ans.append("%20");
            else
                ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
