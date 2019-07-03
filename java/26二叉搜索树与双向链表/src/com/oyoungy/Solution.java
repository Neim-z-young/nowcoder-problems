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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(2);
        root2.left.left.left.left = new TreeNode(1);
        TreeNode newNode = ans.Convert(root2);
        System.out.println();
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        TreeNode left, right, lmax, rmin;
        //处理左右子树及根结点
        if(pRootOfTree.left==null && pRootOfTree.right==null) {
            return pRootOfTree;
        }else {
            left= Convert(pRootOfTree.left);
            right = Convert(pRootOfTree.right);
        }
        lmax = left;
        rmin = right;
        //左右子树各自的最大最小结点
        if(left!=null){
            while (lmax.right!=null && lmax.val<lmax.right.val){
                lmax = lmax.right;
            }
            pRootOfTree.left = lmax;
            lmax.right = pRootOfTree;
        }
        if(right!=null){
            while (rmin!=null && rmin.left!=null && rmin.val>rmin.left.val){
                rmin = rmin.left;
            }
            pRootOfTree.right = rmin;
            rmin.left = pRootOfTree;
        }
        while (pRootOfTree.left!=null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public TreeNode Convert1(TreeNode pRootOfTree) {   //转换为循环链表（偏题了
        if(pRootOfTree==null) return null;
        TreeNode left, right, lmax, lmin, rmax, rmin;
        //处理左右子树及根结点
        if(pRootOfTree.left==null && pRootOfTree.right==null){
            pRootOfTree.left = pRootOfTree;
            pRootOfTree.right = pRootOfTree;
            left = right = pRootOfTree;
        }else if(pRootOfTree.left==null){
            right = Convert(pRootOfTree.right);
            left = pRootOfTree;
            left.right = pRootOfTree;
            left.left = pRootOfTree;
        }else if(pRootOfTree.right==null){
            left = Convert(pRootOfTree.left);
            right = pRootOfTree;
            right.right = pRootOfTree;
            right.left = pRootOfTree;
        }else {
            left= Convert(pRootOfTree.left);
            right = Convert(pRootOfTree.right);
        }
        lmax = lmin = left;
        rmax = rmin = right;
        //左右子树各自的最大最小结点
        while (lmax.val<lmax.right.val){
            lmax = lmax.right;
        }
        while (lmin.val>lmin.left.val){
            lmin = lmin.left;
        }
        while (rmax.val<rmax.right.val){
            rmax = rmax.right;
        }
        while (rmin.val>rmin.left.val){
            rmin = rmin.left;
        }
        pRootOfTree.left = lmax;
        lmax.right = pRootOfTree;
        pRootOfTree.right = rmin;
        rmin.left = pRootOfTree;
        lmin.left = rmax;
        rmax.right = lmin;
        return lmin;
    }
}