package com.oyoungy;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ans.FindContinuousSequence(3);
        System.out.println();
    }

    /***
     * 根据等差数列的性质进行计算
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(sum%2==1){  //奇数可由2个正数和构成
            if(sum/2>0) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(sum / 2);
                temp.add(sum / 2 + 1);
                ans.add(temp);
            }
        }
        //除数最大界限未定(等差数列求和，界限值应当根据求和公式 S=((n-1)*n)/2 计算==>  n<sqrt(2*S))
        for(int i = 3; i<sum/2+1; i++){
            int quotient  = sum/i;
            //能整除
            if(quotient*i == sum){
                if(i%2==0 && quotient%2==1){  // i is even, and quotient is odd
                    int low = quotient/2 - i + 1;
                    if(low>0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        for(int j=low; j<low + i*2; j++){
                            temp.add(j);
                        }
                        ans.add(temp);
                    }
                }else if(i%2==1){
                    int low = quotient-i/2;
                    if(low>0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        for(int j=low; j<low + i; j++){
                            temp.add(j);
                        }
                        ans.add(temp);
                    }
                }
            }
        }
        //按数组的最小值排序
        ans.sort((a1, a2)->{
            if(a1.get(0)>a2.get(0)) return 1;
            else if(a1.get(0)<a2.get(0)) return -1;
            else return 0;
        });
        return ans;
    }

    /***
     * 另一种思路为滑动窗口
     */
}