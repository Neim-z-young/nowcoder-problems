package com.oyoungy;

import javax.swing.table.TableRowSorter;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.isNumeric(new char[]{'5', 'e', '2'}));
        System.out.println(ans.isNumeric(new char[]{'1', '0', '0'}));
        System.out.println(ans.isNumeric(new char[]{'3', '.', '1', '4', '1', '6'}));
        System.out.println(ans.isNumeric(new char[]{'+', '5', '0', '0'}));
        System.out.println(ans.isNumeric(new char[]{'+', '.', '2'}));
        System.out.println(ans.isNumeric(new char[]{'+', '.', '2', '.'}));
    }
    public boolean isNumeric(char[] str) {
        int eInx = containsE(str, 0, str.length);
        if(eInx==0 || eInx==str.length-1) return false;
        if(eInx==-1) eInx = str.length;
        int pointInx = containsPoint(str, 0, eInx);
        if(pointInx==eInx-1){
            return false;
        }
        if(pointInx==-1) pointInx = eInx;
        if(!isInteger(str, 0, pointInx) || !isUnsignedInteger(str, pointInx+1, eInx)|| !isInteger(str, eInx+1, str.length)) return false;
        return true;
    }
    private int containsE(char[] str, int low, int high){
        if(low>=high) return -1;
        for(int i=low; i<high; i++){
            if(str[i]=='e' || str[i]=='E'){
                return i;
            }
        }
        return -1;
    }
    private int containsPoint(char[] str, int low, int high){
        if(low>=high) return -1;
        for(int i=low; i<high; i++){
            if(str[i]=='.'){
                return i;
            }
        }
        return -1;
    }
    private boolean isUnsignedInteger(char[] str, int low ,int high){
        if(low>=high) return true;
        for(int i=low; i<high; i++){
            if(str[i]<'0' || str[i]>'9'){
                return false;
            }
        }
        return true;
    }
    private boolean isInteger(char[] str, int low ,int high){
        if(low>=high) return true;
        if(str[low]=='+' || str[low]=='-'){
            low++;
        }
        for(int i=low; i<high; i++){
            if(str[i]<'0' || str[i]>'9'){
                return false;
            }
        }
        return true;
    }
}