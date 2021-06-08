package com.yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *
 * 面试题 16.19. 水域大小
 *
 *
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 *
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-4-12 19:23
 */
public class LeetCode16_19 {

    public static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < land.length ; i++) {
            int[] l = land[i];
            for (int j = 0 ; j < l.length ; j++) {
                int n = find(i, j, land);
                if(n > 0){
                    list.add(n);
                }
            }
        }
        list.sort(Integer::compareTo);
        int[] a = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static int find(int x , int y , int[][] land){
        if(x < 0 || x == land.length){
            return 0;
        }
        if(y < 0 || y == land[x].length){
            return 0;
        }
        if(land[x][y] == 0){
            int n = 1;
            land[x][y] = -1;
            n = n
                    + find(x+1 , y , land)
                    + find(x , y+1 , land)
                    + find(x+1 , y+1 , land)
                    + find(x , y-1 , land)
                    + find(x+1 , y-1 , land)
                    + find(x-1 , y-1 , land)
                    + find(x-1 , y , land)
                    + find(x-1 , y+1 , land);
            return n;
        }else {
            return 0;
        }
    }

}
