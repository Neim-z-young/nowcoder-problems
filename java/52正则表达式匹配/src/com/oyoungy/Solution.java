package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.match(new char[]{'a','a', 'a'}, new char[]{'a','b', '*', 'a','a'}));
        System.out.println(ans.match(new char[]{}, new char[]{'.'}));
        System.out.println(ans.match(new char[]{}, new char[]{'.', '*'}));
        System.out.println(ans.match(new char[]{'a'}, new char[]{'.', '*'}));
    }
    public boolean match(char[] str, char[] pattern)
    {
        if(str==null && pattern==null) return false;
        if(str.length==0 && pattern.length==0) return true;
        return isMatch(str, 0, pattern, 0);
    }

    private boolean isMatch(char[] str, int strInx, char[] pattern, int patInx) {
        if (strInx == str.length && patInx == pattern.length) return true;
        if (strInx != str.length && patInx == pattern.length) return false;

        if (patInx < pattern.length - 1 && pattern[patInx + 1] == '*') {
            if (strInx < str.length && (str[strInx] == pattern[patInx] || pattern[patInx] == '.')) {
                //相等时*号匹配0或1--n次的状态
                return isMatch(str, strInx, pattern, patInx + 2) || isMatch(str, strInx + 1, pattern, patInx);
            } else //不相等时*匹配0次
                return isMatch(str, strInx, pattern, patInx + 2);
        } else if (strInx < str.length && patInx < pattern.length) {
            if (str[strInx] == pattern[patInx] || (str[strInx] != '\0' && pattern[patInx] == '.')) {
                return isMatch(str, strInx + 1, pattern, patInx + 1);
            } else return false;
        }
        return false;

    }
}