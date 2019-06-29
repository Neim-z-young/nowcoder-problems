package com.oyoungy;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(ans.ReverseList1(listNode));
    }

    public ListNode ReverseList(ListNode head) {     // 栈实现
        if(head==null || head.next == null) return head;
        Stack<ListNode> sNode = new Stack<>();
        while (head!=null){
            sNode.push(head);
            head=head.next;
        }
        ListNode newHead = null, temp = null;
        while (!sNode.empty()){
            if(newHead==null) {
                newHead = sNode.pop();
                temp = newHead;
            }
            temp.next = sNode.pop();
            temp = temp.next;
        }
        temp.next = null;
        return newHead;
    }

    public ListNode ReverseList1(ListNode head) {     // 纯链表操作
        if(head==null || head.next == null) return head;
        ListNode newHead = null, temp = head;
        while (head!=null){
            head = head.next;
            temp.next = newHead;
            newHead = temp;
            temp = head;
        }
        return newHead;
    }
}