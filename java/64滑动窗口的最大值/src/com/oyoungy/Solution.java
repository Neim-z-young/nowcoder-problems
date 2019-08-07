package com.oyoungy;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /**
     * 采用双端队列，队列中保存元素下标，且队列第一个值保存最大值的下标
     * 滑动窗口移动时，从队列后面开始添加元素k
     * 且对于k前面的元素x，若k>x 则移除x
     *                     若k<x 则根据x的下标是否超出窗口范围来确定是否移除x
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> maxs = new ArrayList<>();
        if(num==null || num.length<size || size<1) return maxs;
        LinkedList<Integer> indexDeque = new LinkedList<>();
        for(int i=0; i<size-1; i++){
            while (!indexDeque.isEmpty() && num[indexDeque.getLast()]<num[i]){
                indexDeque.removeLast();
            }
            indexDeque.add(i);
        }
        for(int i=size-1; i<num.length; i++){
            while (!indexDeque.isEmpty() && num[indexDeque.getLast()]<num[i]){
                indexDeque.removeLast();
            }
            indexDeque.add(i);
            if(i-indexDeque.getFirst()+1>size){
                indexDeque.removeFirst();
            }
            maxs.add(num[indexDeque.getFirst()]);
        }
        return maxs;
    }
}