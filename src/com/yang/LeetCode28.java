package com.yang;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 28. 实现 strStr()
 *
 *
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *  
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-4-20 10:59
 */
public class LeetCode28 {

    /**
     * Sunday算法
     *
     * 从前往后匹配的算法（BM算法是从后向前的），在匹配失败时重点关注的是文本串中参加匹配的最末位字符的下一位字符。
     *
     * 如果该字符没有在模式串中出现则直接跳过，即移动位数 = 模式串长度 + 1。
     *
     * 否则，其移动位数 = 模式串长度 - 该字符最右出现的位置(以0开始) = 模式串中该字符最右出现的位置到尾部的距离 + 1。
     *
     * Sunday算法最巧妙的地方，就在于它发现匹配失败之后可以直接考察文本串中参加匹配的最末尾字符的下一个字符。
     *
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(haystack == null){
            return -1;
        }
        if(needle == null){
            return -1;
        }
        int m = needle.length();
        if(m == 0){
            return m;
        }
        int n = haystack.length();
        if(n == 0 || m > n){
            return -1;
        }
        Map<Character , Integer> tempMap = new HashMap<>(n);

        // 模式串P中每个字母出现的最后的下标
        // 所对应的主串参与匹配的最末位字符的下一位字符移动到该位，所需要的移动位数
        for (int i = 0 ; i < m ; i++) {
            tempMap.put(needle.charAt(i) , m - i);
        }
        // 模式串开始位置在主串的哪里
        int s = 0;
        // 模式串已经匹配到的位置
        while (s <= n - m){
            int j = 0;
            while (haystack.charAt(s+j) == needle.charAt(j)){
                j++;
                if(j >= m){
                    return s;
                }
            }
            int index = s + m;
            if(index >= n){
                return -1;
            }
            Integer a = tempMap.get(haystack.charAt(index));
            if(a != null){
                s+= a;
            }else {
                s+=m+1;
            }

        }
        return -1;
    }
}
