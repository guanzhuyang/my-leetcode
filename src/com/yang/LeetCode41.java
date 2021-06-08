package com.yang;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 *
 * 41. 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *  
 *
 * 限制：
 *
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-3-2 14:55
 */
public class LeetCode41 {

    Queue<Integer> big , small;


    /** initialize your data structure here. */
    public LeetCode41() {
        big = new PriorityQueue<>();
        small = new PriorityQueue<>((a , b) -> b-a);
    }

    public void addNum(int num) {
        //数量为偶数 , 放入大根堆
        if(big.size() == small.size()){
            small.add(num);
            big.add(small.poll());
        }else {
            big.add(num);
            small.add(big.poll());
        }
    }

    public double findMedian() {
        if(big.size() == small.size()){
            return ((double)(big.peek() + small.peek()) ) / 2;
        }else {
            return big.peek();
        }
    }

}