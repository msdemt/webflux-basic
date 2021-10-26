package com.example.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 并行流
 */
public class StreamDemo5 {
    public static void main(String[] args) {
        //并行流使用的线程池：ForkJoinPool.commonPool
        //默认的线程数是 当前机器的cpu个数
        //使用如下属性可以修改默认的线程数
        // System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        // IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();

        //使用自己的线程池，不使用默认线程池，防止任务被阻塞
        // 线程名字 : ForkJoinPool-1
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(() -> IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count());
        pool.shutdown();

        //让主线程不要退出
        synchronized (pool) {
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + "debug " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug2(int i) {
        System.err.println("err debug " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
