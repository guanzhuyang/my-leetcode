package com.yang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *  
 *
 * 示例：
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *  
 *
 * 提示：
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-4-9 14:24
 */
public class LeetCode401 {



    public List<String> readBinaryWatch(int turnedOn) {
        Map<Integer , String[]> hours = new HashMap<>(8);
        hours.put(0 , new String[]{"0"});
        hours.put(1 , new String[]{"1" , "2" , "4" , "8"});
        hours.put(2 , new String[]{"3" , "5" , "9" , "6" , "10"});
        hours.put(3 , new String[]{"7" , "11"});

        Map<Integer , String[]> mints = new HashMap<>(8);
        mints.put(0 , new String[]{"00"});
        mints.put(1 , new String[]{"01" , "02" , "04" , "08" , "16" , "32"});
        mints.put(2 , new String[]{"03" ,"05" ,"09" ,"17" ,"33" ,"06" ,"10" ,"18" ,"34" ,"12" ,"20" ,"36" ,"24" ,"40" ,"48"});
        mints.put(3 , new String[]{"07" ,"11" ,"19" ,"35" ,"13" ,"21" ,"37" ,"25" ,"41" ,"49" ,"14" ,"22" ,"38" ,"26" ,"42" ,"50" ,"28" ,"44" ,"52" ,"56"});
        mints.put(4 , new String[]{"58" ,"54" ,"46" ,"30" ,"57" ,"53" ,"45" ,"29" ,"51" ,"43" ,"27" ,"39" ,"23" ,"15"});
        mints.put(5 , new String[]{"59" ,"55" ,"47" ,"31"});

        List<String> results = new ArrayList<>();
        for (int i = 0 ; i <= turnedOn && i < 4; i++) {
            String[] a = hours.get(i);
            int n = turnedOn - i;
            if(n > 5){
                continue;
            }
            String[] b = mints.get(n);
            for (String a1 : a) {
                for (String b1 : b) {
                    results.add(a1 + ":" + b1);
                }
            }
        }

        return results;
    }

}
