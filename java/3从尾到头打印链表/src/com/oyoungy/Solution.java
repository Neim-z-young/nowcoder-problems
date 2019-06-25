package com.oyoungy;

import java.util.ArrayList;
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
        ArrayList<Integer> array = new ArrayList<>(ans.printListFromTailToHead(listNode));
        listNode.next.next.next.next = new ListNode(5);
        ArrayList<Integer> array2 = new ArrayList<>(ans.printListFromTailToHead(listNode));
        System.out.println("ok");
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> array = new ArrayList<>();
        ListNode node = listNode;
        while(node!=null)
        {
            array.add(node.val);
            node = node.next;
        }

        for(int i = 0; i<array.size()/2; i++)
        {
            int t = array.get(i);
            array.set(i, array.get(array.size()-i-1));
            array.set(array.size()-i-1, t);
        }
        return array;
    }
}