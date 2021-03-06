package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

class Dog {
    private String name = "哮天犬";
    /**
     * 默认10斤狗粮
     */
    private int food = 10;

    /**
     * 无参的构造函数
     */
    public Dog() {

    }

    /**
     * 带参数的构造函数
     * @param name
     */
    public Dog(String name) {
        this.name = name;
    }

    /**
     * 狗叫，静态方法
     * @param dog
     */
    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /**
     * 吃狗粮
     * JDK默认会把当前实例传入到非静态方法，参数名为this，位置是第一个
     * @param num
     * @return
     */
    public int eat(Dog this, int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

public class MethodRefrenceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(1);

        //静态方法的方法引用
        Consumer<Dog> consumer = Dog::bark;
        consumer.accept(dog);

        //非静态方法，使用对象实例的方法引用
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤狗粮");

        //使用类名来方法引用
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤狗粮");

        //构造函数的方法引用
        //空参构造函数，没有输入，有一个输出，使用Supplier
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了对象：" + supplier.get());
        //带参数的构造函数的方法引用，有一个输入，一个输出，使用Function
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象：" + function2.apply("旺财"));

        List<String> list = new ArrayList<>();
        test(list);
        System.out.println(list); //[]
    }

    private static void test(List<String> list) {
        list = null;
    }
}
