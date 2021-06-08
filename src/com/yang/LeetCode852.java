package com.yang;

/**
 * @description:
 * 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
示例 1：

输入：arr = [0,1,0]
输出：1
示例 2：

输入：arr = [0,2,1,0]
输出：1
示例 3：

输入：arr = [0,10,5,2]
输出：1
示例 4：

输入：arr = [3,4,5,1]
输出：2
示例 5：

输入：arr = [24,69,100,99,79,78,67,36,26,19]
输出：2
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yang
 * @time:2021 2021-2-25 13:44
 */
public class LeetCode852 {
    //二分查找
    public static int peakIndexInMountainArray(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int start = 0  , end = arr.length - 1 , mid;
        while (start < end){
            mid = (end + start) / 2;
            if(start == mid){
                if(arr[end] > arr[start]){
                    return end;
                }
                return start;
            }
            //大于后一位数
            boolean a = arr[mid] > arr[mid + 1];
            //大于前一位数
            boolean b = a && arr[mid] > arr[mid - 1];
            if(!a){
                start = mid;
                continue;
            }
            if(!b){
                end = mid;
                continue;
            }
            if(b){
                return mid;
            }
        }
        return -1;
    }
}
