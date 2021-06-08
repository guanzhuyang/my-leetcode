package com.yang;

/**
 * @description:
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *  
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-5-18 15:41
 */
public class MapSum {

    Node node;

    /** Initialize your data structure here. */
    public MapSum() {
        node = new Node();
    }

    public void insert(String key, int val) {
        node.insert(key,val,0);
    }

    public int sum(String prefix) {
        return node.sum(prefix,0);
    }

    private class Node{
        int n = 0;
        Node[] nodes = new Node[26];

        public void insert(String key, int val , int index) {
            if(key.length() == index){
                n=val;
                return;
            }
            int c = key.charAt(index) - 'a';
            if(nodes[c] == null){
                nodes[c] = new Node();
            }
            nodes[c].insert(key, val, index+1);
        }

        public int sum(String prefix , int index) {
            if(prefix.length() == index){
                return n;
            }
            int i = prefix.charAt(index) - 'a';
            if (nodes[i] != null) {
                return nodes[i].sum(prefix, index+1);
            }
            return 0;
        }
    }


}
