package com.bit.test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-23
 * Time: 17:37
 */

import java.util.ArrayList;

/**
 * ？作为 通配符 在泛型中的使用
 */
class Test{
    /**
     * T 表示我知道 list 里面数据的具体类型，所以，我使用相对应的 T 类型 来接收，并打印
     */
    public static <T> void print1(ArrayList<T> list){
        //用 确定的 T 类型来接收
        for (T x:list) {
            System.out.print(x+" ");
        }
    }

    /**
     * 注意一点：
     * 通配符 顾名思义就是我不知道 list 里面的数据类型，所以在传的时候，使用 通配符 。
     */
    public static void print2(ArrayList<?> list){
        //由于不知道具体的类型，所以在这里我使用 Object 来接收，它可以接收任何的类型。
        for (Object x:list) {
            System.out.print(x+" ");
        }
    }
}

public class TestDemo2 {

    /**
     * 通配符的上界不适合写入数据，只适合读取数据
     */
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Double> list2 = new ArrayList<>();
        ArrayList<? extends Number> list = list1;    //确定了 通配符 的上界
        //list.add(0,1);           //报错
        //list.add(1,3.14);        //报错
        Number n = list.get(0);
        //Integer i = list.get(0); //报错
        //Double j = list.get(0);  //报错
    }

    public static void main1(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(1);
        //最后打印的结果都是一样的
        Test.print1(list);
        System.out.println();
        Test.print2(list);
    }
}
