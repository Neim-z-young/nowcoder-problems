package com.oyoungy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null) return false;
        if(isSubtree(root1, root2)) return true;
        if(HasSubtree(root1.left, root2)) return true;
        if(HasSubtree(root1.right, root2)) return true;
        return false;
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root2==null) return true;    //只要root2==null 就认为是子树
        if(root1==null) return false;
        if(root1.val == root2.val){
            return isSubtree(root1.left, root2.left)&&isSubtree(root1.right, root2.right);
        }
        return false;
    }
}