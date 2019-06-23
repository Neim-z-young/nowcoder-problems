package com.oyoungy;

public class Solution {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {5, 6, 7},{8, 9, 10}};
        Solution ans = new Solution();
        System.out.println(ans.Find(5, array));
        System.out.println(ans.Find(6, array));
        System.out.println(ans.Find(7, array));
        System.out.println(ans.Find(1, array));
        System.out.println(ans.Find(10, array));
    }

    //按每一行进行二分搜索
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        if(row<1) return false;
        int col = array[0].length;
        if(col<1) return false;
        if(array[0][0]>target || array[row-1][col-1]<target) return false;
        for(int i=0; i<row; i++)
        {
            int low = 0,high = col-1;
            while (low<=high)  //row biSearch
            {
                int mid = low + (high-low)/2;
                if(array[i][mid]<target)
                    low = mid+1;
                else if(array[i][mid]>target)
                    high = mid-1;
                else
                    return true;
            }
        }
        return false;
    }

    //一开始没看清题目的结果
    public boolean FindSorted(int target, int [][] array) {
        int row = array.length;
        if(row<1) return false;
        int col = array[0].length;
        if(col<1) return false;
        if(array[0][0]>target || array[row-1][col-1]<target) return false;
        int low = 0, high = row-1;
        int mid = low + (high-low)/2;
        while (low<high) //col biSearch
        {
            if(array[mid][col-1]>=target)
                high = mid;
            else if(array[mid][0]<=target)
                low = mid;
            if(array[low][col-1]<target)
                low++;
            if(array[high][0]>target)
                high--;
            mid = low + (high-low)/2;
        }
        int rInx = mid;
        low = 0;
        high = col-1;
        mid = low + (high-low)/2;
        while (low<high)  //row biSearch
        {
            if(array[rInx][mid]<target)
                low = mid+1;
            else if(array[rInx][mid]>target)
                high = mid;
            else
                break;
            mid = low + (high - low)/2;
        }
        return array[rInx][mid]==target;
    }
}
