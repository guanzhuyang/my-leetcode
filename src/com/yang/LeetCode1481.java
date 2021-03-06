package com.yang;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 *
 * 1481. 不同整数的最少数目
 *
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-4-26 11:05
 */
public class LeetCode1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer , Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            Integer n = map.getOrDefault(i, 0);
            map.put(i , n+1);
        }
        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
        int size = map.keySet().size();
        int n = k;
        for (int i : collect) {
            if(n > i){
                n -= i;
                size--;
            }else {
                break;
            }
        }
        return size;
    }
}
