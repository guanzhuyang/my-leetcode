package com.yang;

/**
 * @description:
 *
 * 908. 最小差值 I
 *
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 *
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-3-13 15:00
 */
public class LeetCode908 {

    public int smallestRangeI(int[] A, int K) {
        int max = -1 , min = Integer.MAX_VALUE;
        for (int i = 0 ; i < A.length ; i++) {
            max = Math.max(max , A[i]);
            min = Math.min(min , A[i]);
        }
        int d = max - min;
        int a = 2*K;
        if(d > a){
            return d - a;
        }else {
            return 0;
        }
    }
}
