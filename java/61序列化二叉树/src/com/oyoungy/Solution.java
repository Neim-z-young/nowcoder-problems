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
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        System.out.println(ans.Serialize(root));
    }
    private static int index = 0;
    //通过前序遍历进行序列化
    String Serialize(TreeNode root) {
        if(root==null) return "n,";
        String str = new String(Integer.toString(root.val)+",");
        str+=Serialize(root.left);
        str+=Serialize(root.right);
        return str;
    }
    TreeNode Deserialize(String str) {
        String[] nodes = str.split(",");
        index = -1;
        return deserialize(nodes);
    }
    private TreeNode deserialize(String[] nodes){
        index++;
        if(index>=nodes.length) return null;
        if(nodes[index].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}