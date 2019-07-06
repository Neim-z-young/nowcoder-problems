package com.oyoungy;

import java.util.concurrent.CountDownLatch;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 3, 4, 3}));
    }

    public int MoreThanHalfNum_Solution(int [] array) { //O(n)时间，O(1)空间，采用标记
        if(array==null) return 0;
        if(array.length==1) return array[0];
        int flag = 1, ans = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i]==ans){
                flag++;
            }else{
                flag--;
            }
            if(flag==0){
                ans = array[i];
                flag=1;
            }
        }
        flag=0;
        for(int i=0; i<array.length; i++){  //再次验证，这种情况{2，3，2，3，1}
            if(array[i]==ans)
                flag++;
        }
        return flag>array.length/2?ans:0;
    }
}