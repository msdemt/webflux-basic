package com.example.lambda;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class FunctionDemo {
    public static void main(String[] args) {
        // 断言函数接口
        IntPredicate predicate = i -> i > 0;
        System.out.println(predicate.test(-9));

        // 消费函数接口
        IntConsumer consumer = s -> System.out.println(s);
        consumer.accept(1);
    }
}
