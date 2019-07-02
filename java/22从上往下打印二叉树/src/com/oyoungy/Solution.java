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

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> array = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(head!=null){
                array.add(head.val);
                queue.add(head.left);
                queue.add(head.right);
            }
        }
        return array;
    }
}