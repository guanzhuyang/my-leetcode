package com.yang;

/**
 * @description:
 *
 * 304. 二维区域和检索 - 矩阵不可变
 *
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *  
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 *
 * 提示：
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yang
 * @time:2021 2021-3-2 10:24
 */
public class LeetCode304 {

    int[][] matrix;

    public LeetCode304(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            this.matrix = new int[0][0];
            return;
        }
        this.matrix = new int[matrix.length][matrix[0].length];
        this.matrix[0][0] = matrix[0][0];
        for (int i = 1 ; i < matrix[0].length ; i++) {
            this.matrix[0][i] = this.matrix[0][i-1]+matrix[0][i];
        }

        for (int i = 1 ; i < matrix.length ; i++) {
            int sum = 0;
            for (int j = 0 ; j < matrix[i].length ; j++) {
                sum+=matrix[i][j];
                this.matrix[i][j] = this.matrix[i-1][j]+sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0){
            if(col1 == 0){
                return matrix[row2][col2];
            }else {
                return matrix[row2][col2] - matrix[row2][col1 - 1];
            }
        }else {
            if(col1 == 0){
                return matrix[row2][col2] - matrix[row1 - 1][col2];
            }else {
                return matrix[row2][col2] - matrix[row2][col1 - 1] - matrix[row1 - 1][col2] + matrix[row1 - 1][col1 - 1];
            }
        }
    }

}
