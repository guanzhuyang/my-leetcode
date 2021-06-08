package com.yang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 *
 * 224. 基本计算器
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-3-10 10:02
 */
public class LeetCode224 {

    public static int calculate(String s) {
        List<String> hz = toHz(s);
        return cal(hz);
    }
    public static List<String> toHz(String s){
        LinkedList<Character> queue = new LinkedList<>();
        List<String> hz = new ArrayList<>();
        int len = s.length();
        for (int i = 0 ; i < len ; i++) {
            char c = s.charAt(i);
            if(c == '('){
                queue.add(c);
            }else if(c == '+' || c == '-'){

                Character poll = queue.peekLast();
                while (poll != null && (poll == '+' || poll == '-')){
                    hz.add(String.valueOf(queue.pollLast()));
                    poll = queue.peekLast();
                }
                queue.add(c);
            }else if(c == ')'){
                Character poll = queue.pollLast();
                while (poll != null && poll != '('){
                    hz.add(String.valueOf(poll));
                    poll = queue.pollLast();
                }
            }else if (c == ' '){

            }
            else {
                int j = i + 1;
                while (j < len && (s.charAt(j) >= '0' && s.charAt(j) <= '9')){
                    j++;
                }
                hz.add(s.substring(i , j));
                i = j - 1;
            }
        }
        while (!queue.isEmpty()){
            hz.add(String.valueOf(queue.poll()));
        }
        return hz;
    }

    public static int cal(List<String> hz){
        LinkedList<Integer> queue = new LinkedList<>();
        for (String s : hz) {
            if("+".equals(s)){
                Integer a = queue.pollLast();
                Integer b = queue.pollLast();
                a = a == null ? 0 : a;
                b = b == null ? 0 : b;
                queue.add(a+b);
            }else if("-".equals(s)){
                Integer a = queue.pollLast();
                Integer b = queue.pollLast();
                a = a == null ? 0 : a;
                b = b == null ? 0 : b;
                queue.add(b-a);
            }else {
                queue.add(Integer.valueOf(s));
            }
        }
        return queue.pollLast();
    }
}
