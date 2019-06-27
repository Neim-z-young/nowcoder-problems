package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.JumpFloorII(1));
        System.out.println(ans.JumpFloorII(2));
        System.out.println(ans.JumpFloorII(3));
        System.out.println(ans.JumpFloorII(4));
        System.out.println(ans.JumpFloorII(5));
    }
    public int JumpFloorIIRecur(int target) {   // f(n) = f(n-1) + f(n-2) +...+ f(2) + f(1) + 1  递归法
        if(target==0) return 0;
        if(target==1) return 1;
        int cumula = 1;
        for(int i=target-1; i>=1; i--){
            cumula += JumpFloorII(i);
        }
        return cumula;
    }
    public int JumpFloorII(int target) {   // f(n) = f(n-1) + f(n-2) +...+ f(2) + f(1) + 1  规律法
        if(target==0) return 0;            //=> f(n-1) = f(n-2) + ...+ f(1) + 1
        int cumula = 1;                    //=> f(n) = 2* f(n-1)
        for(int i=target-1; i>=1; i--){
            cumula *= 2;
        }
        return cumula;
    }
}
