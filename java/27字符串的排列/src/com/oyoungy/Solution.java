package com.oyoungy;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ArrayList<String> arrayList = ans.Permutation2("aabc");
        System.out.println();
    }

    private ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str!=null && str.length()>0){
            BackTracking(str.toCharArray(), 0);
            ans.sort((s1, s2)->s1.compareTo(s2));
        }
        return ans;
    }

    private void BackTracking(char[] subStr, int start){   //采用回溯法
        ArrayList<String> result = new ArrayList<>();
        if(start==subStr.length){
            if(evaluate(subStr)){
                ans.add(new String(subStr));
            }
        }
        for(int i=start; i<subStr.length; i++){

            swap(subStr, start, i);
            BackTracking(subStr, start+1);
            swap(subStr, start, i);
        }
    }
    boolean evaluate(char[] str){
        return !ans.contains(new String(str));
    }
    private boolean swap(char[] subStr, int j, int i){   //交换
        if(subStr==null || i+1>subStr.length) return false;
        char c = subStr[j];
        subStr[j] = subStr[i];
        subStr[i] = c;
        return true;
    }


    public ArrayList<String> Permutation2(String str) {  //求取下次排列
        if(str==null) return null;
        if(str.length()==0) return ans;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        do{
            ans.add(new String(chars));
        }while (nextPermutation(chars));
        return ans;
    }

    /**
     *  reverse [from, to)
     * @param str
     * @param from
     * @param to
     */
    private void reverse(char[] str, int from, int to){
        to--;
        int mid = (from+to)/2;
        for(int i=from; i<=mid; i++){
            swap(str, i, to-i+from);
        }
    }
    private boolean nextPermutation(char[] str){
        if(str==null) return false;
        int len = str.length;
        for(int i=len-2; i>=0; i--){
            if(str[i]<str[i+1]){  //从后往前找到一个逆序点
                for(int j = len-1; j>i; j--){
                    if(str[j]>str[i]){
                        swap(str, i, j);
                        reverse(str, i+1, len);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}