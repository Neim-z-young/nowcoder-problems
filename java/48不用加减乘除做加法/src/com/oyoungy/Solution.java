package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.Add(253647, 2342566));
    }


    /**
     * 使用&,^,|的特性进行加法运算
     * 例子 001100
     *    + 000111
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1, int num2) {
        int carry = num1&num2;
        int sum = num1^num2;
        while (carry!=0){
            carry = carry<<1;
            int temp = sum;
            if((sum&carry) == 0){  //进位为0则取或求结果
                sum = sum|carry;
            }else {                //否则继续取异或
                sum = sum^carry;
            }
            carry = carry&temp;    //求进位
        }
        return sum;
    }
}