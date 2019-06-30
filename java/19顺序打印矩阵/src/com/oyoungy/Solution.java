package com.oyoungy;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int [][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int [][] matrix1 = {{1}};
        ans.printMatrix(matrix);
        ans.printMatrix(matrix1);
        System.out.println();
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {   //采用一系列的标志位来判断条件
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return null;
        ArrayList<Integer> array = new ArrayList<>();
        int colL = 0, colU = matrix[0].length, rowL = 0, rowU = matrix.length, col = colL, row = rowL; //当前状态的上下界
        boolean isInc = true, isRow = true;    //判断行/列的递增/减
        while (colL < colU && rowL < rowU) {
            array.add(matrix[row][col]);
            System.out.print(matrix[row][col]+ " ");
            if (isRow) {    //打印行
                if (isInc) {
                    col++;
                    if (col == colU) {
                        isRow = !isRow;
                        rowL++;
                        col--;
                        row++;
                    }
                } else {
                    col--;
                    if (col == colL-1) {
                        isRow = !isRow;
                        rowU--;
                        col++;
                        row--;
                    }
                }
            } else {     //打印列
                if (isInc) {
                    row++;
                    if (row == rowU) {
                        isRow = !isRow;
                        colU--;
                        isInc = !isInc;
                        row--;
                        col--;
                    }
                } else {
                    row--;
                    if (row == rowL-1) {
                        isRow = !isRow;
                        colL++;
                        isInc = !isInc;
                        row++;
                        col++;
                    }
                }
            }
        }
        return array;
    }
}