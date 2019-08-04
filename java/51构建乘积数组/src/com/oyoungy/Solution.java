package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println();
    }

    /** 计算以下矩阵的上下三角矩阵的值，下三角中第i行都是第i-1行的值乘以Ai-1
     *     A0  A1  A2  ...  Aj  ... An-2  An-1
     * B0  1
     * B1      1
     * B2          1
     * ..
     * Bi                  1
     * ..
     * Bn-2                         1
     * Bn-1                              1
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if(A==null) return null;
        int[] downTri = new int[A.length];
        int[] upTri = new int[A.length];
        downTri[0] = 1;
        upTri[upTri.length-1] = 1;
        for(int i=1; i<downTri.length; i++){
            downTri[i] = downTri[i-1]*A[i-1];
        }
        for(int i= upTri.length-2; i>=0; i--){
            upTri[i] = upTri[i+1]*A[i+1];
        }
        int[] B = new int[A.length];
        for(int i=0; i<B.length; i++){
            B[i] = downTri[i]*upTri[i];
        }
        return B;
    }
}