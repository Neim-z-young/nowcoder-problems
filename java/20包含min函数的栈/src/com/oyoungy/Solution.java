package com.oyoungy;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    private Stack<Integer> myStack = new Stack<>();
    private int minValue = Integer.MAX_VALUE;
    public void push(int node) {
        myStack.push(node);
        if(node<minValue) minValue = node;
    }

    public void pop() {      //在pop出最小值时使用辅助栈更新最小值
        int pop = myStack.pop();
        if(pop==minValue){
            Stack<Integer> temp = new Stack<>();
            minValue = Integer.MAX_VALUE;
            while (!myStack.empty()){
                temp.push(myStack.pop());
            }
            while (!temp.empty()){
                push(temp.pop());
            }
        }
    }

    public int top() {
        return myStack.peek();
    }

    public int min() {
        return minValue;
    }

    //使用两个栈实现
    Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
    public void push1(int node){
        stack1.push(node);
        if(stack2.empty()) stack2.push(node);
        else if(stack2.peek()>node) stack2.push(node);
    }
    public void pop1(){
        int value = stack1.pop();
        if(value==stack2.peek()) stack2.pop();   //点睛之笔
    }

    public int top1(){
        return stack1.peek();
    }

    public int min1(){
        return stack2.peek();
    }
}