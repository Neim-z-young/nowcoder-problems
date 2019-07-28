package com.oyoungy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.PrintMinNumber(new int[]{3, 32, 321}));
    }

    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0) return "";
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            arrayList.add(Integer.toString(numbers[i]));
        }
        String ans = "";

/*对arraylist内的数据进行排序，按照 将a和b转为string后
 若 a＋b<b+a  a排在在前 的规则排序,
 如 2 21 因为 212 < 221 所以 排序后为 21 2
  to_string() 可以将int 转化为string
*/
        arrayList.sort((s1, s2)-> {
            int i1 = Integer.parseInt(s1+s2);
            int i2 = Integer.parseInt(s2+s1);
            if(i1>i2) return 1;
            else if(i1<i2)return -1;
            else return 0;
        });
        for(int i=0; i<arrayList.size(); i++){
            ans+=arrayList.get(i);
        }
        return ans;
    }
}