package com.oyoungy;

import java.util.ArrayList;
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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(pRoot==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int rowCount=1, count=0;
        while (rowCount>0){
            ArrayList<Integer> array = new ArrayList<>();
            //计录每行的结点数
            while (rowCount-->0){
                TreeNode temp = queue.poll();
                array.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                    count++;
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    count++;
                }
            }
            rowCount = count;
            count=0;
            ans.add(array);
        }
        return ans;
    }
}