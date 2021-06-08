package com.yang;

import java.util.Arrays;

/**
 * @description:
 *
 * 354. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-3-4 10:12
 */
public class LeetCode354 {

    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes , (a , b) -> {
            int i = a[0] - b[0];
            if(i == 0){
                return a[1] - b[1];
            }
            return i;
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1 ; i < n ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
            max = Math.max(max , dp[i]);
        }
        return max;
    }

    // TODO: 2021-3-4 未实现
    public static int maxEnvelopes1(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes , (a , b) -> {
            int i = a[0] - b[0];
            if(i == 0){
                return a[1] - b[1];
            }
            return i;
        });
        int n = envelopes.length;
        int[] dp = new int[n + 1];
        dp[1] = envelopes[0][1];
        int len = 1;
        for (int i = 1 ; i < n ; i++) {
            int ind = envelopes[i][1];
            if(ind > dp[len]){
                dp[++len] = ind;
            }else {
                int s = 1 , e = len , pos = 0;
                while (s <= e){
                    int mid = (e + s) >> 1;
                    if(ind > dp[mid]){
                        pos = mid;
                        s = mid + 1;
                    }else {
                        e = mid - 1;
                    }
                }
                dp[pos+1] = i;
            }
        }
        return len;
    }
}
