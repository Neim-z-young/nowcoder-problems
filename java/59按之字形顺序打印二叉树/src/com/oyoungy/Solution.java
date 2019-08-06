package com.oyoungy;

import java.util.ArrayList;
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
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(pRoot==null) return ans;
        //奇数行
        Stack<TreeNode> oddStack = new Stack<>();
        //偶数行
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(pRoot);
        while (!oddStack.empty() || !evenStack.empty()){
            ArrayList<Integer> oddRow = new ArrayList<>();
            //奇数行子结点添加顺序从左至右
            while (!oddStack.empty()){
                TreeNode temp = oddStack.pop();
                oddRow.add(temp.val);
                if(temp.left!=null){
                    evenStack.push(temp.left);
                }
                if(temp.right!=null){
                    evenStack.push(temp.right);
                }
            }
            if(oddRow.size()!=0) ans.add(oddRow);
            ArrayList<Integer> evenRow = new ArrayList<>();
            //偶数行子结点添加顺序从右至左
            while (!evenStack.empty()){
                TreeNode temp = evenStack.pop();
                evenRow.add(temp.val);
                if(temp.right!=null){
                    oddStack.push(temp.right);
                }
                if(temp.left!=null){
                    oddStack.push(temp.left);
                }
            }
            if(evenRow.size()!=0) ans.add(evenRow);
        }
        return ans;
    }
}