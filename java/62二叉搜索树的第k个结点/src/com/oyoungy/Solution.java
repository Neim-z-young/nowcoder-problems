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
    private int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        TreeNode node = pRoot;
        if(pRoot==null) return null;
        //左子树中寻找第k个结点
        node = KthNode(pRoot.left, k);
        if(node!=null){
            return node;
        }
        count++;
        if (count == k) return pRoot;
        //右子树中寻找第k个结点
        return KthNode(pRoot.right, k);
    }


}