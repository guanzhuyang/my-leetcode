package com.yang;

/**
 * @description:
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yang
 * @time:2021 2021-3-25 09:55
 */
public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode nh = new ListNode(0);
        nh.next = head;
        ListNode n = nh;
        ListNode f = head;
        ListNode s = f.next;
        boolean flag = false;
        while (s != null){
            //相同元素
            if(f.val == s.val){
                s = s.next;
                flag = true;
            }else {
                if(flag){
                    n.next = s;
                    f = s;
                    s = s.next;
                }else {
                    n = n.next;
                    f = f.next;
                    s = s.next;
                }
                flag = false;
            }
        }
        if(flag){
            n.next = null;
        }
        return nh.next;

    }

}
