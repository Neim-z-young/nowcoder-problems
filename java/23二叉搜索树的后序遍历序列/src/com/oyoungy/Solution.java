package com.oyoungy;

import java.util.Arrays;

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

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) return false;
        int len = sequence.length;
        if(len==1) return true;
        int root = sequence[len-1], index1 = 0, index2 = -1;  //标记左右子树的下标
        for(int i=len-2; i>=0; i--){
            if(sequence[i]<root){
                index2 = i;
                break;
            }
        }
        boolean flag = true;  //即使左右子树为空也不影响判断
        if(index1<index2+1){  //左子树
            int [] left = Arrays.copyOfRange(sequence, index1, index2+1);
            for(int j = 0; j<left.length; j++){   //左子树与树根的关系
                if(left[j]>root) return false;
            }
            flag = VerifySquenceOfBST(left);
        }
        if(flag && index2+1<len-1){  //右子树
            int[] right = Arrays.copyOfRange(sequence, index2+1, len-1);
            for(int j = 0; j<right.length; j++){   //右子树与树根的关系
                if(right[j]<root) return false;
            }
            flag = VerifySquenceOfBST(right);
        }
        return flag;
    }
}