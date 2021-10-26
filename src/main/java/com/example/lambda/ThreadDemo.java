package com.example.lambda;

/**
 * 函数式编程和命令式编程简洁性对比
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 命令式编程
        Object target = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread((Runnable) target).start();

        // jdk8 lambda 函数式编程
        Object target2 = (Runnable) () -> System.out.println("ok");
        new Thread((Runnable) target2).start();
    }
}
