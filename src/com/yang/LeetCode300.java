package com.yang;

import java.util.Arrays;

/**
 * @description:
 * @author: yang
 * @time:2021 2021-3-4 11:26
 */
public class LeetCode300 {

    //动态规划
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1 ; i < n ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
            max = Math.max(max , dp[i]);
        }
        return max;
    }

    //贪心+二分查找
    public static int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int len = 1;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 1 ; i < n ; i++) {
            if(nums[i] > dp[len]){
                dp[++len] = nums[i];
            }else {
                int s = 1 , e = len , pos = 0;
                while (s <= e){
                    int mid = (e + s) >> 1;
                    if(nums[i] > dp[mid]){
                        pos = mid;
                        s = mid + 1;
                    }else {
                        e = mid - 1;
                    }
                }
                dp[pos+1] = nums[i];
            }
        }
        return len;
    }

}
