package com.oyoungy;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int [] a={1,2,3,4,5}, b ={4,5,3,2,1}, c ={4,3,5,1,2}, d ={4,3,5,2,1};
        System.out.println(ans.IsPopOrder(a, b));
        System.out.println(ans.IsPopOrder(a, c));
        System.out.println(ans.IsPopOrder(a, d));
    }

    /**
     * 用一个压入顺序栈解决问题
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length!=popA.length || pushA.length==0) return false;
        Stack<Integer> stack1 = new Stack<>();
        int index1 = 0, index2 = 0;
        while (index2!=popA.length){
            if(stack1.isEmpty() || stack1.peek()!=popA[index2]){
                while (index1!=pushA.length && pushA[index1]!=popA[index2]){
                    stack1.push(pushA[index1]);    //后弹出的值入栈
                    index1++;
                }
                index1++;
            }else {
                stack1.pop();
            }
            index2++;
        }
        return stack1.isEmpty();
    }
}