package com.oyoungy;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int [] a={1,2,3,4,5}, b ={4,5,3,2,1}, c ={4,3,5,1,2};
        System.out.println(ans.IsPopOrder(a, b));
        System.out.println(ans.IsPopOrder(a, c));
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length!=popA.length || pushA.length==0) return false;
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        stack2.push(-1);      //用于弹出区间的下界[0,index)
        int index1 = 0, index2 = 0;
        while (index1!=pushA.length){
            if(pushA[index1]!=popA[index2]){
                stack1.push(pushA[index1]);    //后弹出的值入栈
                index1++;
            }else {
                stack2.push(index2);   //缓存先弹出值的对应index
                index1++;
                index2++;
            }
        }
        int up = popA.length, low;
        while (!stack2.empty()){  //通过缓存的下标比对弹出顺序
            low = stack2.pop();
            for(int i = low+1; i<up; i++){    //对应弹出的区间
                if(stack1.empty() || stack1.pop()!=popA[i]) return false;
            }
            up = low;
        }
        return true;
    }
}