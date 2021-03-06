package com.yang;

/**
 * @description:
 *
 * 633. 平方数之和
 *
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-4-28 09:36
 */
public class LeetCode633 {

    public boolean judgeSquareSum(int c) {
        int right = (int) Math.sqrt(c);
        int left = 1;
        while (left <= right){
            int n = left * left + right * right;
            if(n == c){
                return true;
            }else if (n < c){
                left++;
            }else {
                right --;
            }
        }
        return false;
    }
}
