package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.StrToInt("-"));
        System.out.println(ans.StrToInt("2147483647"));
        System.out.println(ans.StrToInt("-2147483649"));
        System.out.println(ans.StrToInt("-2147483648"));
    }
    public int StrToInt(String str) {
        //字符串不能直接比较
        if(str==null || str.length()==0) return 0;
        boolean flag = (str.charAt(0)=='+' || str.charAt(0)=='-')?true:false;
        int ans = 0;
        int index = 0;
        if(flag){
            index = 1;
        }
        boolean positive = true;
        if(flag && str.charAt(0)=='-'){
            positive = false;
        }
        for(int i = index; i < str.length(); i++) {
            int temp = str.charAt(i) - '0';
            if (temp < 0 || temp > 9) {
                return 0;
            }
            //判断数值是否越界
            if(positive){
                if(ans>214748364 || (ans==214748364 && temp>7)){
                    return 0;
                }
                ans = ans*10 + temp;
            }else {
                if(ans<-214748364 || (ans==-214748364 && temp>8)){
                    return 0;
                }
                ans = ans*10 - temp;
            }
        }
        return ans;
    }
}