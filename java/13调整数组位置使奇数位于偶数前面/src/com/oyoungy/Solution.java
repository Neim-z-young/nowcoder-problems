package com.oyoungy;

import java.util.Arrays;

public class Solution {

    public void reOrderArray(int [] array) {  //时空间均O(n)
        int[] newA = new int[array.length];
        int count=0;
        for(int i=0; i<array.length; i++){
            if((array[i] & 1)==1){
                newA[count] = array[i];
                count++;
            }
        }
        for(int i=0; i<array.length; i++){
            if((array[i] & 1)==0){
                newA[count] = array[i];
                count++;
            }
        }
        for(int i=0; i<array.length; i++){
            array[i] = newA[i];
        }
    }
}
