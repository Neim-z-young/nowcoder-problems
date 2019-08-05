package com.oyoungy;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null) return null;
        TreeLinkNode node = pNode;
        if(pNode.right!=null){   //存在右子结点
            node = pNode.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }else {   //回溯到父结点
            while (node.next!=null && node.next.right==node){
                node = node.next;
            }
            return node.next;
        }
    }
}