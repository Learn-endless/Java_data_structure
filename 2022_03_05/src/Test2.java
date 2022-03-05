import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-05
 * Time: 21:44
 */
public class Test2 {

    public static void main(String[] args) {
        try {
            Class<?> demo2 = Class.forName("TestDemo2");

            /**
             * 这里调用的是 TestDemo2 枚举类 的 无参构造方法
             * 那我们在这里传的两个参数是什么?
             * 我们自定义枚举类型,都是默认 继承 Enum 类的,而 Enum 只有一个有两个参数的构造方法:
             * protected Enum(String name, int ordinal)
             * 所以我们给的这两个参数,是用来调用 Enum 的构造方法的
             *
             * 最终我们还是会抛出异常:
             * Cannot reflectively create enum objects
             * 所以枚举类型非常安全
             *
             *
             * 面试题:如何实现一个线程安全的单例模式(只能获取对象的一个实例)???
             */
            Constructor<?> constructor = demo2.getDeclaredConstructor(String.class,int.class);

            constructor.setAccessible(true);

            TestDemo2 testDemo2 = (TestDemo2) constructor.newInstance("green",4);

            System.out.println(testDemo2);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static void main2(String[] args) {
        TestDemo2 value = TestDemo2.valueOf("YELLOW");
        System.out.println(value);

        //compareTo()默认是通过 索引 来比较的
        System.out.println(TestDemo2.RED.compareTo(TestDemo2.YELLOW));
    }

    public static void main1(String[] args) {
        System.out.println(TestDemo2.YELLOW);
        //返回一个 枚举 数组, 枚举类名.values()
        TestDemo2[] t = TestDemo2.values();
        for (int i = 0; i < t.length; i++) {
            //枚举对象.ordinal() 获取该枚举对象的 索引
            System.out.println(t[i]+"->"+t[i].ordinal());
        }
    }
}
