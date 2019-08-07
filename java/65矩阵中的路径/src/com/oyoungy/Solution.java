package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        char[] chars = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = new char[]{ 'b', 'c', 'c', 'e', 'd'};
        char[] str2 = new char[]{ 'a', 'b', 'c', 'b'};
        System.out.println(ans.hasPath(chars, 3, 4, str));
        System.out.println(ans.hasPath(chars, 3, 4, str2));
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        Node node = new Node(rows, cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(hasPath(matrix, i, j, str, 0, node)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean hasPath(char[] matrix, int row, int col, char[] str, int index, Node node){
        int rows = node.rows, cols = node.cols;
        if(index==str.length) return true;
        if(row<0 || row>=rows || col<0 || col>=cols || matrix[row*cols+col]!=str[index]){
            return false;
        }
        if(node.state[row*cols+col]==true){
            return false;
        }
        node.state[row*cols+col] = true;
        //up
        if(hasPath(matrix, row-1, col, str, index+1, node)){
            return true;
        }
        //down
        if(hasPath(matrix, row+1, col, str, index+1, node)){
            return true;
        }
        //left
        if(hasPath(matrix, row, col-1, str, index+1, node)){
            return true;
        }
        //right
        if(hasPath(matrix, row, col+1, str, index+1, node)){
            return true;
        }
        return node.state[row*cols+col] = false;
    }
}
//保存矩阵中数据的访问状态
class Node{
    public boolean [] state;
    int rows = 0;
    int cols = 0;
    public Node(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        state = new boolean[rows*cols];
    }
}