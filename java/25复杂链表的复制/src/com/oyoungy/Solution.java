package com.oyoungy;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        //在原链表基础上复制链表
        RandomListNode p = pHead;
        while (p!=null){
            RandomListNode newP = new RandomListNode(p.label);
            newP.next = p.next;
            p.next = newP;
            p = newP.next;
        }
        //设置新链表的链接
        p = pHead;
        while (p!=null){
            if(p.random==null)
                p.next.random = null;
            else
                p.next.random = p.random.next;
            p=p.next.next;
        }
        //拆分链表
        RandomListNode newHead = pHead.next, newNode = pHead.next;
        p = pHead;
        while (newNode.next!=null){
            p.next = newNode.next;
            newNode.next = p.next.next;
            p = p.next;
            newNode = newNode.next;
        }
        p.next = null;
        return newHead;
    }
}