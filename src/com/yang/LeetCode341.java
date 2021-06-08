package com.yang;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 *
 * 341. 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author: yang
 * @time:2021 2021-3-23 14:06
 */
public class LeetCode341 implements Iterator<Integer> {

    Integer[] temp ;

    int p = 0;


    public LeetCode341(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList<>();
        mapNest(nestedList , list);
        temp = list.toArray(new Integer[0]);
    }

    private void mapNest(List<NestedInteger> nestedList , List<Integer> list){
        for (NestedInteger integer : nestedList) {
            if(integer.isInteger()){
                list.add(integer.getInteger());
            }else {
                mapNest(integer.getList() , list);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return p != temp.length;
    }

    @Override
    public Integer next() {
        Integer i = temp[p];
        p++;
        return i;
    }
}
