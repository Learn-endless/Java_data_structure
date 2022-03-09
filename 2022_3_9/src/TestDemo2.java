import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-09
 * Time: 16:02
 */
class Test{
    public void test(){
        System.out.println("test()...");
    }
}

//函数式接口
@FunctionalInterface
interface A {
    void test(int a);
}


public class TestDemo2 {

    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"china");
        map.put(3,"english");
        map.put(4,"chinese");

        //使用 lambda 表达式
        map.forEach((key,value)-> System.out.println("key->"+key+"; value->"+value));
        System.out.println("=====分割线=====");

        //使用 匿名内部类
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("key->"+integer+"; value->"+s);
            }
        });
    }

    public static void main3(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("china");
        list.add("math");
        list.add("student");
        //使用 lambda 表达式遍历打印 list 中的内容
        list.forEach(s-> System.out.println(s));

        //排序 sort()也可以使用 lambda 表达式
        list.sort((o1,o2)->o1.compareTo(o2));
        System.out.println("====分割线====");

        //匿名内部类 的写法
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        //使用匿名内部类的写法:调用 forEach 训话打印 list 中的内容
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    //lambda 中也有 变量捕获
    public static void main2(String[] args) {
        int b = 199;
        A t = a-> System.out.println("变量捕获::"+b);
        t.test(2022);
    }

    public static void main1(String[] args) {
        int a = 199;
//        a = 200;   //如果发生过修改,那么就捕获不到 a

        //匿名内部类
        new Test(){
            @Override
            public void test(){
                //这里就发生了变量捕获
                //注意:前提:a是一个常量,或者a没有发生过修改
                System.out.println("变量捕获:a=="+a);
            }
        }.test();
    }
}
