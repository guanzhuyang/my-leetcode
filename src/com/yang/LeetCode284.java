package com.yang;

import java.util.Iterator;

/**
 * @description:
 * @author: yang
 * @time:2021 2021-3-31 14:13
 */
public class LeetCode284 implements Iterator<Integer> {

    Iterator<Integer> iterator;

    Integer temp;

    public LeetCode284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return temp != null || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if(temp == null){
            return iterator.next();
        }
        Integer t = this.temp;
        temp = null;
        return t;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(temp == null){
            Integer next = iterator.next();
            temp = next;
            return next;
        }
        return temp;
    }
}
