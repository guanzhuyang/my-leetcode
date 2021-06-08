package com.yang;

/**
 * @description:
 *
 * 74. 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-3-30 09:26
 */
public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int n = matrix[0].length;
        int e = matrix.length - 1;
        int s = 0 , mid = (e + s) >> 1;
        while (s <= e){
            if(matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0] > target){
                e = mid - 1;
                mid = (e + s) >> 1;
            }else {
                if(matrix[mid][n - 1] >= target){
                    return binarySearch(matrix[mid] , target);
                }else {
                    s = mid + 1;
                    mid = (e + s) >> 1;
                }
            }
        }
        return false;
    }

    public boolean binarySearch(int[] values , int target){
        int end = values.length - 1;
        int s = 0 , mid = (end + s) >> 1;
        while (s <= end){
            if(values[mid] == target){
                return true;
            }
            if(values[mid] > target){
                end = mid - 1;
            }else {
                s = mid + 1;
            }
            mid = (end + s) >> 1;
        }
        return false;
    }

}
