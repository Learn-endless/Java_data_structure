import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-09
 * Time: 15:09
 */

//@FunctionalInterface 表示它是一个 ---函数式接口
//无返回值无参数
@FunctionalInterface
interface Person{
    //可以有静态常量
    public static final int a = 123;
    //该方法中有且只有一个抽象方法.
    void test();
    //可以有 default 方法
    default void test2(){
        System.out.println("这是一个default方法...2");
    }
    default void test3(){
        System.out.println("这是一个default方法...3");
    }
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}

//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,double b);
}

//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}


public class Lambdademo {

    public static void main4(String[] args) {
        //使用lambda表达式,创建 优先级队列

        //使用 lambda 表达式的写法
        PriorityQueue<Integer> pr1 = new PriorityQueue<>(3,(o1,o2)->o1-o2);


        //原先使用 匿名内部类 的写法
        PriorityQueue<Integer> pr = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public static void main7(String[] args) {
        //有返回值,多个参数
        MoreParameterReturn m = (int a,int b)->{return a+b;};
        int ret = m.test(2,3);
        System.out.println(ret);
        //优化:多个参数时,可以省略类型,只有一条语句可以省略 return
        MoreParameterReturn m1 = (a,b)->a+b;
        int tmp = m.test(2,3);
        System.out.println(tmp);
    }

    public static void main6(String[] args) {
        //使用有返回值,一个参数
        OneParameterReturn o = (n)->{return n;};
        int ret = o.test(2022);
        System.out.println(ret);
        //优化: 只有一个参数可以省略括号,return也可以省略
        OneParameterReturn o1 = n->n;
        int tmp = o1.test(2022);
        System.out.println(tmp);
    }

    public static void main5(String[] args) {
        //使用有返回值,无参数
        NoParameterReturn n = ()->{return 10;};
        int ret = n.test();
        System.out.println(ret);
        //优化:return可以省略掉
        NoParameterReturn n1 = ()->10;
        int tmp = n1.test();
        System.out.println(tmp);
    }

    public static void main(String[] args) {
        //使用多个参数,无返回值
        MoreParameterNoReturn n = (int a,double b)->{System.out.println(a+b);};
        n.test(100,99.15);
        //优化: 多个参数时,可以省略 类型
        MoreParameterNoReturn n1 = (a,b)->System.out.println(a+b);
        n1.test(100,99.666);
    }

    public static void main3(String[] args) {
        //使用一个参数,无返回值
        OneParameterNoReturn o = (a)->{System.out.println("值为::"+a);};
        o.test(10);
        //优化: 只有一个参数,可以将括号省略,只有一条语句,可以省略花括号
        OneParameterNoReturn o1 = a->System.out.println("值为::"+a);
        o1.test(10);
    }

    //使用lambda表达式
    public static void main2(String[] args) {
        Person person = ()-> System.out.println("重写方法2...");
        person.test();
        person.test2();
        person.test3();
        System.out.println(person.a);
        System.out.println(Person.a);
    }

    //平常使用接口,用一个类实现 该接口,然后重写该接口的抽象方法
    public static void main1(String[] args) {
        Person person = new Person() {
            @Override
            public void test() {
                System.out.println("重写方法1...");
            }
        };
        //调用重写后的test()方法
        person.test();
    }
}
