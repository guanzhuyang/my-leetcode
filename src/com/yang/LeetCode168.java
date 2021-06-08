package com.yang;

/**
 * @description:
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-6-7 16:31
 */
public class LeetCode168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder b = new StringBuilder();
        int c = 0 , a = 0;
        while (true){
            a = columnNumber / 26;
            c = columnNumber % 26;
            if(c == 0){
                b.insert(0 , 'Z');
                a --;
            }else {
                b.insert(0 , (char)(64+c));
            }
            if(a == 0){
                break;
            }
            columnNumber = a;
        }
        return b.toString();
    }
}
