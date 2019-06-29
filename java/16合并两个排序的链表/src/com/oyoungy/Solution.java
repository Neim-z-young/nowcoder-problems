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
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        listNode1.next.next.next = new ListNode(7);
        System.out.println(ans.Merge(listNode1, listNode).val);
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode newList = null, temp = null;
        if(list1.val<list2.val){
            newList = list1;
            temp = newList;
            list1 = list1.next;
        }else {
            newList = list2;
            temp = newList;
            list2 = list2.next;
        }
        temp.next = null;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
            temp.next = null;
        }
        if(list1==null) temp.next = list2;
        else temp.next = list1;
        return newList;
    }
}