package com.oyoungy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ArrayList a1 = ans.GetLeastNumbers_Solution(new int[]{1, 2, 3, 3, 4, 3}, 2);
        ArrayList a2 = ans.GetLeastNumbers_Solution(new int[]{1, 2, 3, 3, 4, 3}, 1);
        ArrayList a3 = ans.GetLeastNumbers_Solution(new int[]{1, 2, 3, 3, 4, 3}, 6);
        System.out.println();
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        return getLeastNumbers(input, 0, input.length, k);
    }
    private ArrayList<Integer> getLeastNumbers(int [] input, int start, int end, int k){
        //[start, end)

        ArrayList<Integer> ans = new ArrayList<>();
        if(start>=end || k>end || k<start) return ans;

        while(start<end){
            //do partition
            int inx = partition(input, start, end);
            if(inx==k){
                ans.addAll(new ArrayList<Integer>(Arrays.stream(Arrays.copyOfRange(input, start, inx)).boxed().collect(Collectors.toList())));
                break;
            }else if(inx<k){
                ans.addAll(new ArrayList<Integer>(Arrays.stream(Arrays.copyOfRange(input, start, inx+1)).boxed().collect(Collectors.toList())));
                start = inx+1;
            }else if(inx>k){
                end = inx;
            }
        }
        return ans;
    }
    private int partition(int [] input, int start, int end){
        //[start, end)
        if(end==start) return -1;
        if(end - start==1) return start;
        int pivot = input[start], high = end-1, low = start;
        while (high>low){ //low == high 时跳出循环，而且low对应的数组值可与pivot交换
            while(input[high]>pivot && high>=start){
                high--;
            }
            while (input[low]<=pivot && low<end && low<high){
                low++;
            }
            int temp = input[high];
            input[high] = input[low];
            input[low] = temp;
        }
        int temp = input[start];
        input[start] = input[low];
        input[low] = temp;
        return low;
    }
}
