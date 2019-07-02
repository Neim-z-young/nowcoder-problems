package com.oyoungy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
        ArrayList<ArrayList<Integer>> arrayLists = ans.FindPath(root, 22);
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(new ArrayList<>());
        if(root==null) return ans;
        if(root.left!=null){
            ArrayList<ArrayList<Integer>> left = FindPath(root.left, target-root.val);
            for(int i=0; i<left.size(); i++){
                left.get(i).add(0,root.val);
            }
            ans.addAll(left);
        }
        if(root.right!=null){
            ArrayList<ArrayList<Integer>> right = FindPath(root.right, target-root.val);
            for(int i=0; i<right.size(); i++){
                right.get(i).add(0,root.val);
            }
            ans.addAll(right);
        }
        ans.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()>o2.size()) return -1;
                if(o1.size()<o2.size()) return  1;
                return 0;
            }
        });
        if(root.val==target && root.left==null && root.right==null){
            ans.add(new ArrayList<Integer>(Arrays.asList(target)));
        }
        return ans;
    }
}