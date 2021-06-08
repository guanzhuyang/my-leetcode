package com.yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:统计所有小于非负整数 n 的质数的数量。
 *     <p>
 *     <p>示例 1：
 *     <p>输入：n = 10 输出：4 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。 示例 2：
 *     <p>输入：n = 0 输出：0 示例 3：
 *     <p>输入：n = 1 输出：0
 *     <p>提示：
 *     <p>0 <= n <= 5 * 106
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-primes
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yang
 * @time:2020 2020-12-3 17:23
 */
public class LeetCode204 {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        for (int i = 2; i < n; i++) {
            if(isPrime[i] == 0){
                primes.add(i);
            }
            for (int j = 0 ; j < primes.size() && i * primes.get(j) < n;j++){
                isPrime[i * primes.get(j)] = 1;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
