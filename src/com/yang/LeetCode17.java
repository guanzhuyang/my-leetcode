package com.yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-6-3 14:59
 */
public class LeetCode17 {

    char[][] CACHE = new char[][]{{'a','b','c'} , {'d','e','f'} , {'g','h','i'} , {'j','k','l'} , {'m','n','o'} , {'p','q','r' , 's'} , {'t','u','v'} , {'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return ans;
        }
        char[] cs = digits.toCharArray();
        ans.add("");
        for (int i = cs.length - 1 ; i >= 0 ; i--) {
            List<String> cache = new ArrayList<>();
            char[] c = CACHE[cs[i] - '2'];
            for (String an : ans) {
                for (char s : c) {
                    cache.add(s + an);
                }
            }
            ans = cache;
        }
        return ans;
    }

}
