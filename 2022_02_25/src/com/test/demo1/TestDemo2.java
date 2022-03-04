package com.test.demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-25
 * Time: 22:27
 */

class M{
    public void func(){
        System.out.println("我是 M 类中 func 方法");
    }
}

public class TestDemo2 {
    public int a = 1;
    public int b = 0;
    public static int c = 199;

    static class Person{
        public int a = 100;
        public int b = 99;
        public String name = "张三";
        public int id = 556;
        public static int phone = 10010;

        public static void function(){
            System.out.println("我是一个 静态内部类 的静态方法");
        }

        public void func(){
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(name);
            System.out.println(id);
            System.out.println(phone);
        }
    }

    public static void main(String[] args) {
        TestDemo2.Person person = new TestDemo2.Person();
        person.func();
        //访问静态内部类中的静态属性和方法时，可以直接用 内部类名.属性（方法） 就可以
        System.out.println(Person.phone);
        Person.function();

        //这是一个 匿名内部类 ，并且我重写了 func 方法
        new M(){
            @Override
            public void func(){
                System.out.println("我重写了M类中的func方法");
            }
        }.func();
    }
}
