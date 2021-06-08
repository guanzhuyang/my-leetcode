package com.yang;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-6-2 15:13
 */
public class LeetCode523 {

    //超出内存限制
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if(k == 0){
            return true;
        }
        int[][] dp = new int[len][len];
        dp[0][0] = nums[0];
        for (int i = 1 ; i < len ; i++) {
            dp[0][i] = dp[0][i-1] + nums[i];
            if(dp[0][i] % k == 0){
                return true;
            }
        }
        for (int i = 1 ; i < len ; i++) {
            for (int j = i+1 ; j < len ; j++) {
                dp[i][j] = dp[i-1][j] - nums[i-1];
                if(dp[i][j] % k == 0){
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 若区间 [i , j] 为满足条件的区间
     * 则 nums[j] - nums[i] == n * k
     *  --> nums[j] / k - nums[i] / k == n
     *  说明只要 nums[j] , nums[i] 对 K 取余相同则满足条件
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum1(int[] nums, int k) {
        if(k == 0) {
            return true;
        }
        int len = nums.length;
        if(len < 2){
            return false;
        }

        Map<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        int a = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            a = (nums[i] + a) % k;
            Integer c = map.get(a);
            if(c != null){
                if(i - c > 1){
                    return true;
                }
            }else {
                map.put(a , i);
            }
        }
        return false;
    }

}
