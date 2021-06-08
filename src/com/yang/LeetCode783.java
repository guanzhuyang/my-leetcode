package com.yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-4-13 09:45
 */
public class LeetCode783 {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bst(root , list);
        int min = Math.abs(list.get(0) - list.get(1));
        for (int i = 1 ; i < list.size() - 1 ; i++) {
            min = Math.min(min , Math.abs(list.get(i) - list.get(i+1)));
        }
        return min;
    }

    private void bst(TreeNode root , List<Integer> list){
        if(root == null){
            return ;
        }
        if(root.left != null){
            bst(root.left , list);
        }
        list.add(root.val);
        if(root.right != null){
            bst(root.right , list);
        }

    }
}
