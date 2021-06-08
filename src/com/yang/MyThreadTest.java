package com.yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yang
 * @time:2021 2021-5-13 15:15
 */
public class MyThreadTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0 ; i < 1000 ; i++) {
                list.add("a"+i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0 ; i < 1000 ; i++) {
                list.add("b"+i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println("list size is " + list.size());
        System.out.println(list.toString());
    }
}
