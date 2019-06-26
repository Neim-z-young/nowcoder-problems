package com.oyoungy;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop(){  //整齐的代码
        if(stack1.empty()&&stack2.empty())
            throw new RuntimeException("Queue is empty");
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int pop1() {  //丑陋的代码
        if (!stack2.empty()) {
            return stack2.pop();
        }
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        if(stack2.empty())
            return 0;
        return stack2.pop();
    }
}