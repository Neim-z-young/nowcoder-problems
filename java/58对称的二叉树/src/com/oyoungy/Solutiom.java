package com.oyoungy;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solutiom {
    public static void main(String[] args) {
        Solutiom ans = new Solutiom();
        System.out.println();
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null) return true;
        return isLeftRightSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isLeftRightSymmetrical(TreeNode pLeft, TreeNode pRight){
        if(pLeft==null && pRight==null) return true;
        if(pLeft!=null && pRight!=null){
            if(pLeft.val==pRight.val){
                return isLeftRightSymmetrical(pLeft.left, pRight.right)&&isLeftRightSymmetrical(pLeft.right, pRight.left);
            }
        }
        return false;
    }
}