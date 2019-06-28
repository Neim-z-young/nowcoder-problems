package com.oyoungy;

import javax.xml.stream.FactoryConfigurationError;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.Power(3, -3));
        System.out.println(ans.Power(3, 2));
        System.out.println(ans.Power(-3, 3));
    }

    public double Power(double base, int exponent) {   //二分法
        if(base<1e-10 && base>-1e-10) return 0;
        if(exponent==0) return 1;
        if(exponent==1) return base;
        boolean flag=false;
        if(exponent<0){
            exponent = -exponent;
            flag=true;
        }
        double ans = 0;
        if(exponent%2==0){
            ans = Math.pow(Power(base, exponent/2), 2);
        }else {
            ans = base*Math.pow(Power(base, (exponent-1)/2), 2);
        }
        if(flag){
            ans = 1/ans;
        }
        return ans;
    }

    //TODO 采用位运算
}
