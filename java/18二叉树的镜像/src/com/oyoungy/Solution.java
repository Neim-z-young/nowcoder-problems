package com.oyoungy;

import java.util.LinkedList;
import java.util.Queue;

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

    public void Mirror(TreeNode root) {  //非递归法,使用队列更易于理解，也可使用栈
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tempR = queue.poll(), left = tempR.left, right = tempR.right;
            tempR.left = right;
            tempR.right = left;
            if(tempR.left!=null)
                queue.add(tempR.left);
            if(tempR.right!=null)
                queue.add(tempR.right);
        }
    }

    public void Mirror1(TreeNode root) {  //递归法
        root = exLAndR(root);
    }

    private TreeNode exLAndR(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return root;
        TreeNode left = root.left, right = root.right;
        root.left = exLAndR(right);
        root.right = exLAndR(left);
        return root;
    }

    public void Mirror2(TreeNode root) {  //无需返回值的递归法
        if(root==null || (root.left==null && root.right==null)) return;
        TreeNode left = root.left, right = root.right;
        root.left = right;
        root.right = left;
        Mirror2(root.left);
        Mirror2(root.right);
    }
}