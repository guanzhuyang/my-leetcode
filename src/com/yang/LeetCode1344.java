package com.yang;

/**
 * @description:
 *
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 *
 * 示例 1：
 *
 *
 *
 * 输入：hour = 12, minutes = 30
 * 输出：165
 * 示例 2：
 *
 *
 *
 * 输入：hour = 3, minutes = 30
 * 输出；75
 * 示例 3：
 *
 *
 *
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 * 示例 4：
 *
 * 输入：hour = 4, minutes = 50
 * 输出：155
 * 示例 5：
 *
 * 输入：hour = 12, minutes = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/angle-between-hands-of-a-clock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-4-8 14:49
 */
public class LeetCode1344 {

    public static double angleClock(int hour, int minutes) {
        double v = minutes * 6.0;
        double h = hour * 30.0 + minutes / 2.0;
        if(v > h){
            return angle(v - h);
        }else {
            return angle(h - v);
        }
    }

    private static double angle(double v){
        if(v <= 180.0){
            return v;
        }
        return 360.0 - v;
    }

}
