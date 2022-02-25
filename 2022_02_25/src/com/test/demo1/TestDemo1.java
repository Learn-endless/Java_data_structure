package com.test.demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-25
 * Time: 16:22
 */

class H {
}
interface w{

}
class Person{
    public String ID = "10010";
    public String phone = "18671562563";
    public int a = 1;
    public int b = 0;

    class Student extends H implements w{
        //这是一个 实例内部类
        public int a = 100;
        public int b = 99;

        //在 实例内部类 中不能有静态的成员变量（静态方法完全不可以有），如果非要有成员属性，则只能是一个静态的常量
        public static final int c = 3;

        public void function(){
            System.out.println("这是一个 实例内部类：a + b = "+ (a+b));
            /**
             * 如果想要访问 外部类 中的 同名 成员变量：
             * 外部类类名.this.同名的成员变量名
             */
            System.out.println(Person.this.a+Person.this.b);
        }
    }
    class n extends Student{

    }
}

public class TestDemo1 extends Person.Student{
    //如果一个类继承 一个 实例内部类 的话，就需要 调用 内部类的外部类 的构造方法
    public TestDemo1 (Person o){
        o.super();
    }
    public void func1(){
        class People{
            //这是一个本地内部类
            public String name = "bit";
            public int age = 22;
            public void func(){
                System.out.println("这是一个本地内部类");
            }
        }
        // 缺点：只能在当前方法中使用
        People people = new People();
        people.func();
    }

    public static void main(String[] args) {
//        TestDemo1 testDemo1 = new TestDemo1();
//        testDemo1.func1();
        Person person = new Person();
        // 想实例化 实例内部类
        // 外部类类名.内部类类名 变量名 = 实例化的外部类引用.new 内部类();
        Person.Student student = person.new Student();
        student.function();
    }
}
