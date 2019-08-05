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
        System.out.println();
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null) return pHead;
        ListNode p = pHead;
        boolean isRepeat = false;
        while (p.next!=null){ //去掉与头结点重复的所有结点
            if(p.next.val==pHead.val){
                p.next=p.next.next;
                isRepeat = true;
            } else {
                p = p.next;
            }
        }
        if(isRepeat){
            return deleteDuplication(pHead.next);
        }else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}