package com.yang;

/**
 * @description:
 *
 * 331. 验证二叉树的前序序列化
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yang
 * @time:2021 2021-3-12 13:53
 */
public class LeetCode331 {

    /**
     * 解法1 , 树的出度和入度
     * 在遍历到树的任意节点时 , 都应该有 总出度 >= 总入度
     * 遍历完整棵树后 , 应该 有 总出度 = 总入度
     * 而非空节点的 入度为1 , 出度为2
     * 空节点的 入度为 1 , 出度为 0
     * 可以用一个记录数 , 记录 总出度 - 总入度 的值
     */

    public static boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
        //根节点入度为0
        int buf  = 1;
        int len = preorder.length();
        for (int i = 1 ; i < len ; i++) {
            if(preorder.charAt(i) == ','){
                buf --;
                if(buf < 0) {
                    return false;
                }
                if(preorder.charAt(i - 1) != '#'){
                    buf += 2;
                }
            }
        }
        buf = preorder.charAt(len - 1) == '#' ? buf - 1 : buf + 1;
        return buf == 0;

    }
}
