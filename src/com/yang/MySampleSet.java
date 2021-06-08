package com.yang;

/**
 * @description:
 * @author: yang
 * @time:2021 2021-3-25 11:00
 */
public class MySampleSet {
    long temp = 0;

    public void set(char elem){
        int i = elem - 'A';
        long t = 1 << i;
        temp = temp | t;
    }

    public boolean has(char elem){
        int i = elem - 'A';
        long t = 1 << i;
        return (temp & t) != 0;
    }

}
