package com.example.lambda;

@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);

    default int add(int x, int y) {
        x = this.doubleNum(x);
        return x + y;
    }
}

@FunctionalInterface
interface Interface2 {
    int doubleNum(int i);

    default int add(int x, int y) {
        x = this.doubleNum(x);
        return x + y;
    }
}

@FunctionalInterface
interface Interface3 extends Interface1, Interface2{
    //Duplicate default methods named add with the parameters (int, int) and (int, int) are inherited from the types Interface2 and Interface1
    @Override
    default int add(int x, int y){
        return Interface1.super.add(x, y);
    }
}

public class LambdaDemo1 {
    public static void main(String[] args) {
        Interface1 i1 = i -> i * 2;
        System.out.println(i1.add(3, 7)); //调用接口默认实现的方法
        System.out.println(i1.doubleNum(20)); //调用lambda表达式

    }
}
