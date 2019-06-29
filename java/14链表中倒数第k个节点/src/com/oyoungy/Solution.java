package com.oyoungy;


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
        System.out.println(ans.FindKthToTail(listNode, 1).val);
        System.out.println(ans.FindKthToTail(listNode, 5));
        System.out.println(ans.FindKthToTail(listNode, 4).val);
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null) return null;
        if(k<=0) return null;
        ListNode first = head, second = head;
        while (second!=null && k--!=0){
            second = second.next;
        }
        if(second==null && k!=0) return null;
        while (second!=null){
            second=second.next;
            first=first.next;
        }
        return first;
    }
}