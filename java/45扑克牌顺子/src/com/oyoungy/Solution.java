package com.oyoungy;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.isContinuous(new int[]{1, 3, 0, 7, 0}));
    }

    /**
     * 先排序，后根据0的个数进行排出顺子
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length<5)return false;
        Arrays.sort(numbers);
        int[] seq = new int[numbers.length];
        int zero = 0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==0){
                zero++;
            }
        }
        int index = 0 ;
        seq[index++] = numbers[zero];
        for(int i=zero+1; i<numbers.length;){
            if(numbers[i]==seq[index-1]+1){
                seq[index++] = numbers[i];
                i++;
            }else {
                if(zero-- <= 0) return false;
                seq[index] = seq[index-1]+1;
                index++;
            }
        }
        return true;
    }
}