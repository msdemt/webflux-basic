package com.example.lambda;

import java.util.stream.IntStream;

/**
 * 求最小值
 */
public class MinDemo {
    public static void main(String[] args) {
        int[] nums = { 33, 55, -55, 90, -666, 90 };

        // 命令式编程
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);

        // jdk8 函数式编程 
        // parallel() 支持并行计算
        int min2 = IntStream.of(nums).parallel().min().getAsInt();
        System.out.println(min2);
    }
}
