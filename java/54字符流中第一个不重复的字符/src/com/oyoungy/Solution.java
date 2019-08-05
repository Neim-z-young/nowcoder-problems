package com.oyoungy;


public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    private StringBuilder str = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        str.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int[] charHash = new int[256];
        for(int i=0; i<str.length(); i++){
            charHash[str.charAt(i)]++;
        }
        for(int i=0; i< str.length(); i++){
            if(charHash[str.charAt(i)]==1) return str.charAt(i);
        }
        return '#';
    }
}