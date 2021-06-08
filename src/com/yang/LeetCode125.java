package com.yang;

/**
 * @description:
 *
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-3-8 11:21
 */
public class LeetCode125 {

    public static boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        int len = s.length();
        int left = 0 , right = len - 1;
        while (left < right){
            boolean r = notWord(s.charAt(right));
            boolean l = notWord(s.charAt(left));
            if(r){
                right--;
                continue;
            }
            if(l){
                left++;
                continue;
            }
            if(!compare(s.charAt(left) , s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean notWord(char c){
        if(c > 47 && c < 58){
            return false;
        }
        if(c > 64 && c < 91 ){
            return false;
        }
        if(c > 96 && c < 123 ){
            return false;
        }
        return true;
    }

    private static boolean compare(char a , char b){
        if(b > 90){
            b = (char) (b - 32);
        }
        if(a > 90){
            a = (char) (a - 32);
        }
        return a == b;
    }

}
