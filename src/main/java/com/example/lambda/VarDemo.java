package com.example.lambda;

import java.util.function.Consumer;

/**
 * lambda表达式中的变量引用
 */
public class VarDemo {
    public static void main(String[] args) {
        String str = "我们的时间";
        // str = "";
        Consumer<String> consumer = s -> System.out.println(s + str); // error: Local variable str defined in an enclosing scope must be final or effectively final
        consumer.accept("12211");
    }
}
