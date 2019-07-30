package com.oyoungy;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    //有许多重复计算，未进行剪枝
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int left = GetDepth(root.left);
        int right = GetDepth(root.right);
        if(Math.abs(left-right)>1 || !IsBalanced_Solution(root.left) || !IsBalanced_Solution(root.right)){
            return false;
        }
        return true;
    }

    private int GetDepth(TreeNode root){
        if(root == null) return 0;
        int left = GetDepth(root.left);
        int right = GetDepth(root.right);
        return Math.max(left, right)+1;
    }
}