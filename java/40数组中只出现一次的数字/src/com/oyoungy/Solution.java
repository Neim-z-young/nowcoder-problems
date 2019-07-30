package com.oyoungy;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /***
     * 位运算(异或)
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length < 2) return;
        int xor = 0;
        for(int i=0; i<array.length; i++){
            xor^=array[i];
        }
        int index = 1;
        //找到xor最右边的 '1'所在的位置
        while ((xor&1)!=1){
            xor = xor>>1;
            index = index<<1;
        }
        num1[0] = num2[0] = 0;
        for(int i = 0; i<array.length; i++){
            if((array[i]&index)==0){
                num2[0]^=array[i];
            }else {
                num1[0]^=array[i];
            }
        }
        return;
    }
}