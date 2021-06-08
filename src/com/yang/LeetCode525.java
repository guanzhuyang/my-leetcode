package com.yang;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-6-3 10:55
 */
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0 , total = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            total = total + (nums[i] == 0 ? -1 : 1);
            Integer l = map.get(-total);
            if(l != null){
                max = Math.max(max , i-l);
            }else {
                map.put(total , i);
            }
        }
        return max;
    }

}
