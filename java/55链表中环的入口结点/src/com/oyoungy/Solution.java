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
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null) return null;
        //通过快慢指针判断是否有环。
        ListNode fast = pHead, slow = pHead;
        do{
            if(slow.next==null) return null;
            slow = slow.next;
            if(fast.next==null || fast.next.next==null) return null;
            fast = fast.next.next;
        }while (fast!=slow);
        //相遇点与起点有一定的数学规律
        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}