package com.oyoungy;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ans.Insert(1);
        ans.Insert(2);
        ans.Insert(3);
        ans.Insert(4);
        System.out.println(ans.GetMedian());
    }
    private ArrayList<Integer> array = new ArrayList<>();
    //插入排序 O(n)
    public void Insert(Integer num) {
        for(int i=0; i<array.size(); i++){
            if(array.get(i)>num){
                array.add(i, num);
                return;
            }
        }
        //添加到末尾
        array.add(num);
    }

    public Double GetMedian() {
        int size = array.size();
        if(size%2==0){
            return (array.get(size/2)+array.get(size/2-1))/2.0;
        }else {
            return (double)array.get(size/2);
        }
    }
}