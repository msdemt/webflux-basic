package com.example.stream;

import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        String str = "my name is 007";

        //把每个单词的长度打印出来
        Stream.of(str.split(" ")).map(s -> s.length()).forEach(System.out::println);

        System.out.println("---");
        //打印长度大于2的单词长度
        Stream.of(str.split(" ")).filter(s -> s.length() > 2).map(s -> s.length()).forEach(System.out::println);

        //flatMap  A元素下有B属性，B属性是一个集合，最终得到A元素里B属性的所有元素的集合
        // Type mismatch: cannot convert from IntStream to Stream<? extends Object>
        //IntStream/LongStream并不是Stream的子类，所有要进行装箱 boxed
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(i -> System.out.println((char) i.intValue()));

        System.out.println("---peek---");
        //peek用于debug，是中间操作
        //foreach是终止操作
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);

        //limit主要用于无限流
        new Random().ints().filter(i -> i > 100 && i < 1000).limit(10).forEach(System.out::println);
    }
}
