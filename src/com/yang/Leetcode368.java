package com.yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 368. 最大整除子集
 *
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-4-23 13:33
 */
public class Leetcode368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp , 1);
        int maxSize = 1;
        int maxVal = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if(nums[i] % nums[j] == 0 ){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }

            if(dp[i] > maxSize){
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        if(maxSize == 1){
            result.add(nums[0]);
            return result;
        }
        for (int i = nums.length - 1 ; i >= 0 && maxSize > 0; i--) {
            if(dp[i] == maxSize && maxVal % nums[i] == 0){
                    result.add(nums[i]);
                    maxSize --;
                    maxVal = nums[i];
            }
        }
        return result;
    }

}
