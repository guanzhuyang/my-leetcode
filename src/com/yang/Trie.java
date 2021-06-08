package com.yang;

/**
 * @description:
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *  
 *
 * 提示：
 *
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-4-7 16:13
 */
public class Trie {

    Node[] temp;

    /** Initialize your data structure here. */
    public Trie() {
        temp = new Node[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        int i = word.charAt(0) - 'a';
        if(temp[i] == null){
            temp[i] = new Node();
        }
        temp[i].insert(word , 0 , word.length());
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int i = word.charAt(0) - 'a';
        if(temp[i] == null){
            return false;
        }
        return temp[i].search(word , 1 , word.length());
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int i = prefix.charAt(0) - 'a';
        if(temp[i] == null){
            return false;
        }
        return temp[i].startsWith(prefix , 1 , prefix.length());
    }

    class Node{
        char t;
        Node[] nodes;
        boolean f;

        public Node() {
            t = '0';
            nodes = new Node[26];
            f = false;
        }

        public void insert(String s , int index , int len){
            if(index >= len){
                return;
            }
            if(t == '0'){
                t = s.charAt(index);
            }
            if(index == len - 1){
                f = true;
            }else {
                int n = index + 1;
                char c = s.charAt(n);
                int i = c - 'a';
                if(nodes[i] == null){
                    nodes[i] = new Node();
                }
                nodes[i].insert(s , n , len);
            }
        }

        public boolean search(String s, int index , int len){
            if(index >= len){
                return f;
            }
            int i = s.charAt(index) - 'a';
            if(nodes[i] == null){
                return false;
            }
            return nodes[i].search(s , index+1 , len);
        }

        public boolean startsWith(String s , int index , int len) {
            if(index >= len){
                return true;
            }
            int i = s.charAt(index) - 'a';
            if(nodes[i] == null){
                return false;
            }
            return nodes[i].startsWith(s , index+1 , len);
        }


    }

}
