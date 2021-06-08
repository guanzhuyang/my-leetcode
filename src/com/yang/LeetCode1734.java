package com.yang;

/**
 * @description:
 *
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yang
 * @time:2021 2021-5-11 10:55
 */
public class LeetCode1734 {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int total = 1;
        for (int i = 2 ; i <= n ; i++) {
            total ^= i;
        }
        int odd = encoded[1];
        for (int i = 3 ; i < encoded.length ; i+=2) {
            odd ^= encoded[i];
        }
        int[] p = new int[n];
        p[0] = total ^ odd;
        for (int i = 0 ; i < encoded.length ; i++) {
            p[i+1] = encoded[i] ^ p[i];
        }
        return p;
    }

}
