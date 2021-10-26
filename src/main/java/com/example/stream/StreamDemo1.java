package com.example.stream;

import java.util.stream.IntStream;

public class StreamDemo1 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        //外部迭代，串行计算
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println("结果为：" + sum);

        //使用stream的内部迭代，可以进行并行计算.parallel()，可以惰性求值，可以短路操作
        //map是中间操作（返回stream的操作）
        //sum是终止操作
        int sum2 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum(); //i->i*2使用方法引用为 StreamDemo1::doubleNum
        System.out.println("结果为：" + sum2);

        System.out.println("惰性求值就是终止操作没有调用的情况下，中间操作不会执行");
        IntStream.of(nums).map(StreamDemo1::doubleNum); //不会被调用
    }

    public static int doubleNum(int i) {
        System.out.println("执行了乘以2");
        return i * 2;
    }
}
