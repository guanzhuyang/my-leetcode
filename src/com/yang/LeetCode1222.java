package com.yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 1222. 可以攻击国王的皇后
 *
 *
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 *
 * 「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
 *
 * 「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
 *
 * 请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * 示例 2：
 *
 *
 *
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * 示例 3：
 *
 *
 *
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 *  
 *
 * 提示：
 *
 * 1 <= queens.length <= 63
 * queens[i].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * 一个棋盘格上最多只能放置一枚棋子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queens-that-can-attack-the-king
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-5-7 09:33
 */
public class LeetCode1222 {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int l = king[0] - king[1];
        int r = king[0] + king[1];
        int[][] rlt = new int[8][2];
        int [] a = {-1 , -1};
        Arrays.fill(rlt , a);
        for (int[] queen : queens) {
            if(queen[0] == king[0]){
                if(queen[1] > king[1]){
                    if(rlt[3][0] == -1){
                        rlt[3] = queen;
                    }else {
                        if(queen[1] < rlt[3][1]){
                            rlt[3] = queen;
                        }
                    }
                }else {
                    if(rlt[7][0] == -1){
                        rlt[7] = queen;
                    }else {
                        if(queen[1] > rlt[7][1]){
                            rlt[7] = queen;
                        }
                    }
                }
                continue;
            }
            if(queen[1] == king[1]){
                if(queen[0] > king[0]){
                    if(rlt[5][0] == -1){
                        rlt[5] = queen;
                    }else {
                        if(queen[0] < rlt[5][0]){
                            rlt[5] = queen;
                        }
                    }
                }else {
                    if(rlt[1] == null){
                        rlt[1] = queen;
                    }else {
                        if(queen[0] > rlt[1][0]){
                            rlt[1] = queen;
                        }
                    }
                }
                continue;
            }
            if(queen[0] - queen[1] == l){
                if(queen[1] > king[1]){
                    if(rlt[4][0] == -1){
                        rlt[4] = queen;
                    }else {
                        if(queen[1] < rlt[4][1]){
                            rlt[4] = queen;
                        }
                    }
                }else {
                    if(rlt[0][0] == -1){
                        rlt[0] = queen;
                    }else {
                        if(queen[1] > rlt[0][1]){
                            rlt[0] = queen;
                        }
                    }
                }
                continue;
            }
            if(queen[0] + queen[1] == r){
                if(queen[1] > king[1]){
                    if(rlt[6][0] == -1){
                        rlt[6] = queen;
                    }else {
                        if(queen[1] < rlt[6][1]){
                            rlt[6] = queen;
                        }
                    }
                }else {
                    if(rlt[2][0] == -1){
                        rlt[2] = queen;
                    }else {
                        if(queen[1] > rlt[2][1]){
                            rlt[2] = queen;
                        }
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int[] t : rlt) {
            if(t[0] != -1){
                List<Integer> o = new ArrayList<>(2);
                o.add(t[0]);
                o.add(t[1]);
                list.add(o);
            }
        }
        return list;
    }

}
