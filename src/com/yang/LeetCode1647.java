package com.yang;

import java.util.Arrays;

/**
 * @description:
 *
 * 1647. 字符频次唯一的最小删除次数
 *
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 *
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 *
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 * 示例 2：
 *
 * 输入：s = "aaabbbcc"
 * 输出：2
 * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
 * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
 * 示例 3：
 *
 * 输入：s = "ceabaacb"
 * 输出：2
 * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
 * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 仅含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-deletions-to-make-character-frequencies-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yang
 * @time:2021 2021-3-26 14:56
 */
public class LeetCode1647 {

    public int minDeletions(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        byte[] temp = new byte[26];
        for (char c : s.toCharArray()) {
            temp[c - 'a']++;
        }
        Arrays.sort(temp);
        // TODO: 2021-3-30 未完成
        return 0;
    }

}
