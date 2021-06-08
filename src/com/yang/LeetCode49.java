package com.yang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-4-23 16:52
 */
public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return null;
        }
        Map<String , List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] temp = new int[26];
            for (char c : str.toCharArray()) {
                temp[c - 'a']++;
            }
            StringBuilder b = new StringBuilder();
            for (int i = 0 ; i < temp.length ; i++) {
                b.append((char)(i+'a')).append(temp[i]);
            }
            String key = b.toString();
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
                map.put(key , list);
            }
            list.add(str);
        }
        return map.values().stream().collect(Collectors.toList());
    }

}
