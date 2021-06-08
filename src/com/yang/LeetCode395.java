package com.yang;

import java.util.Arrays;

/**
 * @description:
 *
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-5-8 09:23
 */
public class LeetCode395 {

    public int longestSubstring(String s, int k) {
        int[] temp = new int[26];
        int rlt = 0;
        int len = s.length();
        for (int p = 1  ; p < 27 ; p++) {
            Arrays.fill(temp , 0);
            for (int i = 0 , j = 0 , total = 0 , sum = 0; i < len ; i++) {
                int n = s.charAt(i) - 'a';
                temp[n]++;
                if(temp[n] == 1){
                    total++;
                }
                if(temp[n] == k){
                    sum++;
                }
                //字符超出个数
                while (total > p){
                    int l = s.charAt(j++) - 'a';
                    temp[l]--;
                    if(temp[l] == 0){
                        total--;
                    }
                    if(temp[l] == k-1){
                        sum--;
                    }
                }
                if(sum == total){
                    rlt = Math.max(rlt , i-j+1);
                }
            }
        }
        return rlt;
    }

}
