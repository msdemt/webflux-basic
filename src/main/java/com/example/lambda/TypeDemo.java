package com.example.lambda;

@FunctionalInterface
interface IMath {
    int add(int x, int y);
}

@FunctionalInterface
interface IMath2 {
    int sub(int x, int y);
}

/**
 * 类型推断
 */
public class TypeDemo {
    public static void main(String[] args) {
        //变量类型定义
        IMath lambda = (x, y) -> x + y;
        //数组
        IMath[] lambdas = { (x, y) -> x + y };
        //强转
        Object lambda2 = (IMath) (x, y) -> x + y;
        //通过返回类型
        IMath createLambda = createLambda();

        //在方法里使用lambda表达式
        TypeDemo typeDemo = new TypeDemo();
        //当有二义性的时候，使用强转对应的接口解决
        typeDemo.test((IMath) (x, y) -> x + y); //error: The method test(IMath) is ambiguous for the type TypeDemo 需要进行强转解决该问题
    }

    public void test(IMath math) {

    }

    public void test(IMath2 math) {

    }

    private static IMath createLambda() {
        return (x, y) -> x + y;
    }
}
