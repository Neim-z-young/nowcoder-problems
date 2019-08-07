package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        Node node = new Node(rows, cols);
        return movingCount(threshold,0, 0, node);
    }
    private int movingCount(int threshold, int row, int col, Node node)
    {
        int rows = node.rows, cols = node.cols;
        if(col<0 || col>=cols || row<0 || row>=rows || !checkSums(threshold, row, col) || node.state[row*cols+col]){
            return 0;
        }
        node.state[row*cols+col] = true;
        return 1 +
                movingCount(threshold, row-1, col, node) +
                movingCount(threshold, row+1, col, node) +
                movingCount(threshold, row, col-1, node) +
                movingCount(threshold, row, col+1, node);
    }
    private boolean checkSums(int threshold, int row, int col){
        int temp = 0;
        while (row!=0){
            temp+=row%10;
            row/=10;
        }
        while (col!=0){
            temp+=col%10;
            col/=10;
        }
        return threshold>=temp;
    }
}
//保存方格中数据的访问状态
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