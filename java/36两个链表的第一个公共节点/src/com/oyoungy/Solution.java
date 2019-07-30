package com.oyoungy;

import java.util.HashMap;

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

    /***
     * 使用hashmap法
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        HashMap<ListNode, Integer> node = new HashMap<>();
        while (pHead1!=null){
            node.put(pHead1, 1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            if(node.get(pHead2)!=null){
                break;
            }
            pHead2 = pHead2.next;
        }
        return pHead2;
    }

    /***
     * 链表长度差法
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        int m = 0, n = 0;
        ListNode l1 = pHead1, l2 = pHead2;
        while (pHead1!=null){
            m++;
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            n++;
            pHead2 = pHead2.next;
        }
        int k = m-n;
        if(m>n){
            while (k>0){
                l1 = l1.next;
                k--;
            }
        }else {
            k = -k;
            while (k>0){
                l2 = l2.next;
                k--;
            }
        }
        while (l1!=l2 && l1!=null && l2 !=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    /***
     * 简化差值法
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1!=l2){
            l1 = (l1==null)?pHead2:l1.next;
            l2 = (l2==null)?pHead1:l2.next;
        }
        return l1;
    }
}