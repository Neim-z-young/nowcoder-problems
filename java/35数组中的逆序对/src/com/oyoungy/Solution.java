package com.oyoungy;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.InversePairs(new int[]{1, 2, 3,7 ,123,6, 4, 5}));
    }


    /**
     * 逆序对的个数与归并排序中左右数组的大小关系相关
     * @param array
     * @return
     */

    public int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        return mergeSort(array, 0, array.length);
    }

    private int mergeSort(int [] array, int low, int high){
        if(low==high-1){
            return 0;
        }
        int count = 0;
        int mid = low + (high-low)/2;
        //divide
        count+=mergeSort(array, low, mid);
        if(count>1000000007){
            count%=1000000007;
        }
        count+=mergeSort(array, mid, high);
        if(count>1000000007){
            count%=1000000007;
        }
        //merge
        int [] sorted = new int[high-low];
        int lowInx = low, highInx = mid, cur = 0;
        while (lowInx<mid && highInx< high){
            if(array[lowInx]<=array[highInx]){
                sorted[cur] = array[lowInx];
                lowInx++;
            }else{//左数组中的值大于右数组中的值
                count = count + (mid-lowInx);
                sorted[cur] = array[highInx];
                highInx++;
                if(count>1000000007){
                    count%=1000000007;
                }
            }
            cur++;
        }
        int tl = low, th = high;
        if(lowInx==mid){
            tl = highInx;
        }else if(highInx==high){
            tl = lowInx;
            th = mid;
        }
        for(int i=tl; i<th; i++){
            sorted[cur] = array[i];
            cur++;
        }
        for(int i = high-1; i>=low; i--){
            array[i] = sorted[--cur];
        }
        return count;
    }

    /**
     * using loop
     * @param array
     * @return
     */
    public int InversePairs1(int [] array) {
        int nums = 0;
        for(int i=0; i<array.length; i++){
            for(int j=i; j<array.length; j++){
                if(array[i]>array[j]){
                    nums++;
                }
            }
            if(nums>1000000007){
                nums%=1000000007;
            }
        }
        return nums;
    }

}