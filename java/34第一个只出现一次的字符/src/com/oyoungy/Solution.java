package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.FirstNotRepeatingChar("sdasdf"));
    }
    public int FirstNotRepeatingChar(String str) {
        int lower[] = new int[26];
        int upper[] = new int[26];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c>='a' && c<='z'){
                lower[c-'a'] += 1;
            }else if(c>='A' && c<='Z'){
                upper[c-'A'] += 1;
            }
        }
        int ans=-1;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c>='a' && c<='z' && lower[c-'a'] != 1){
                continue;
            }else if(c>='A' && c<='Z' && upper[c-'A'] != 1){
                continue;
            }
            ans = i;
            break;
        }
        return ans;
    }
}