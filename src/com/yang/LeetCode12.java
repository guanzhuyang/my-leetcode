package com.yang;

/**
 * @description:
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= num <= 3999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-5-14 11:08
 */
public class LeetCode12 {

    public String intToRoman(int num) {
        int a = num / 1000;
        int b = (num / 100) % 10;
        int c = (num / 10) % 10;
        int d = num % 10;
        StringBuilder builder = new StringBuilder();
        if(a > 0){
            for (int i = 0 ; i < a ; i++) {
                builder.append('M');
            }
        }
        if(b > 0){
            builder.append(roman(b , 'C', 'D' ,'M'));
        }
        if(c > 0){
            builder.append(roman(b, 'X', 'L','C'  ));
        }
        if(d > 0){
            builder.append(roman(b, 'I', 'V','X'  ));
        }
        return builder.toString();
    }

    private String roman(int n , char a , char b , char c){
        StringBuilder builder = new StringBuilder();
        if(n == 9){
            builder.append(c).append(a);
            return builder.toString();
        }
        if(n == 4){
            builder.append(b).append(a);
            return builder.toString();
        }
        if(n > 4){
            builder.append(b);
            for (int i = 0 ; i < n - 5 ; i++) {
                builder.append(a);
            }
            return builder.toString();
        }
        for (int i = 0 ; i < n ; i++) {
            builder.append(a);
        }
        return builder.toString();
    }

}
