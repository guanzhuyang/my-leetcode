package com.yang;

import java.util.PriorityQueue;

/**
 * @description:
 *
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * 示例 2：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * 示例 3：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * 示例 4：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-5-19 09:31
 */
public class LeetCode1738 {

    public static int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        minHeap.add(Integer.MIN_VALUE);
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 1 ; j < matrix[i].length ; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[i][j-1];
            }
            for (int j = 0 ; j < matrix[i].length ; j++) {
                if(i > 0){
                    matrix[i][j] = matrix[i][j] ^ matrix[i-1][j];
                }
                if (minHeap.peek() < matrix[i][j]) {
                    if(minHeap.size() == k){
                        minHeap.poll();
                    }
                    minHeap.add(matrix[i][j]);
                }
            }

        }
        return minHeap.peek();
    }

}