package com.yang;

/**
 * @description:
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-4-24 13:58
 */
public class LeetCode905 {

    public int[] sortArrayByParity(int[] A) {
        int[] temp = new int[5002];
        int max = 0;
        for (int i : A) {
            max = Math.max(i , max);
            temp[i]++;
        }
        int j = 0 ;
        for (int i = 0 ; i < max ; i+=2) {
            if(temp[i] > 0){
                for (int k = 0 ; k < temp[i] ; k++) {
                    A[j] = temp[i];
                    j++;
                }
            }
        }
        for (int i = 1 ; i < max ; i+=2) {
            if(temp[i] > 0){
                for (int k = 0 ; k < temp[i] ; k++) {
                    A[j] = temp[i];
                    j++;
                }
            }
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        int[] ans = new int[A.length];
        int left = 0 , right = A.length - 1;
        for (int i : A) {
            if((i & 1) == 0){
                ans[left] = i;
                left++;
            }else {
                ans[right] = i;
                right--;
            }
        }
        return ans;
    }

}
