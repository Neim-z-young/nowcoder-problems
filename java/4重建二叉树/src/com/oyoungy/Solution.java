package com.oyoungy;

import java.util.Arrays;

/**
 * Definition for binary tree
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Solution ans = new Solution();
        TreeNode root = ans.reConstructBinaryTree(pre, in);
        System.out.println();
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int len = pre.length;
        if(len==0 || len!=in.length) return null;
        if(len==1) return new TreeNode(pre[0]);
        TreeNode root = new TreeNode(pre[0]);
        int index=0;
        while (in[index]!=root.val)
        {
            index++;
        }
        root.left = null;
        root.right = null;
        if(index != 0 )
            root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index+1), Arrays.copyOfRange(in, 0, index));
        if(index != len-1)
            root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index+1, len), Arrays.copyOfRange(in, index+1, len));
        return root;
    }
}