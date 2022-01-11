package com.bit.learn1;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList集合的方法的使用
 */
public class TestDemo1 {
    public static String reverseLeftWords(String s, int n) {
//        int num = n % s.length();
//        char[] ret = s.toCharArray();
//        while(num>0){
//            char tmp = ret[0];
//            System.arraycopy(ret,1,ret,0,s.length()-1);
//            ret[s.length()-1]=tmp;
//            num--;
//        }
//        return new String(ret);
        n %= s.length();
        String x = s.substring(0, n);
        String y = s.substring(n, s.length());
        StringBuilder x1 = new StringBuilder(x);
        x1 = x1.reverse();
        StringBuilder y1 = new StringBuilder(y);
        y1 = y1.reverse();
        x1.append(y1);
        x1 = x1.reverse();
        return new String(x1);
    }

    public static void main(String[] args) {
        String ret = reverseLeftWords("abcdef",3);
        System.out.println(ret);

//        StringBuilder s = new StringBuilder();
//        s.append("abcdef");
//        String m = s.reverse().toString();
//        System.out.println(m);

//        String s = "12 3";
//        String ret = s.replace(" ","%20");
//        System.out.println(ret);
//        System.arraycopy();
    }

    public static void main5(String[] args) {
//        List<String> list1 = new ArrayList<>();  //初始化指定数组大小
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();   //线程安全的
        list1.add("hello");
        list1.add(" ");
        list1.add("world");
        list1.add("!");
        //注意只有ListIterator中才有add方法，Iterator没有
        ListIterator<String> it = list1.listIterator();
        while (it.hasNext()) {
            String ret = it.next();
            if (ret.equals("hello")) {
                //如果调用集合本身的add方法
                //会抛出一个异常：ConcurrentModificationException
                //原因：线程不安全，集合需要使用CopyOnWriteArrayList
                list1.add("bit");
            } else {
                System.out.print(ret);
            }
        }
        System.out.println();
        //重新看一下ArrayList集合中的元素内容
        System.out.println(list1);
    }

    public static void main4(String[] args) {
        List<String> list1 = new ArrayList<>();  //初始化指定数组大小
        list1.add("hello");
        list1.add(" ");
        list1.add("world");
        list1.add("!");
        //注意只有ListIterator中才有add方法，Iterator没有
        ListIterator<String> it = list1.listIterator();
        while(it.hasNext()){
            String ret = it.next();
            if(ret.equals("hello")){
                //找到hello时在后面添加一个bit
                it.add("bit");
            }else{
                System.out.print(ret);
            }
        }
        System.out.println();
        //重新看一下ArrayList集合中的元素内容
        System.out.println(list1);
    }

    /*
    Iterator与ListIterator的区别
    ListIterator继承了Iterator
    ListIterator又有一些属于自己的方法
    add或者remove
     */
    public static void main3(String[] args) {
        List<String> list1 = new ArrayList<>(5);  //初始化指定数组大小
        list1.add("hello");
        list1.add(" ");
        list1.add("world");
        list1.add("!");
        Iterator<String> it = list1.iterator();
//        while(it.hasNext()){
//            it.remove();  //直接这样使用会报IllegalStateException异常
//        }
        //正确的用法
        while(it.hasNext()){
            //想要在遍历时remove，就必须先.next（）
            String ret = it.next();
            if(ret.equals("world")){
                it.remove();
            }else{
                System.out.print(ret);
            }
        }
        System.out.println();
        //重新打印看下结果
        System.out.println(list1);
    }

    public static void main2(String[] args) {
        List<String> list1 = new ArrayList<>(5);  //初始化指定数组大小
        list1.add("hello");
        list1.add(" ");
        list1.add("world");
        List<String> list2 = new ArrayList<>();
        list2.add("learn bit");
        //元素也可以是一个集合
        //但作为元素的集合的泛型要与添加元素集合的泛型一致
        list1.addAll(list2);  //使用addAll方法
        System.out.println(list1);
    }

    public static void main1(String[] args) {
        List<String> list1 = new ArrayList<>(5);
        list1.add("hello");
        list1.add(" ");
        list1.add("world");
        list1.add(3,"!");
        //直接打印
        System.out.println(list1);
        //使用增强for循环打印
        for (String s:list1) {
            System.out.print(s+"");
        }
        System.out.println();
        //使用普通for循环打印
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i)+"");
        }
        System.out.println();
        //使用迭代器循环遍历
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+"");
        }
        System.out.println();
        //使用List迭代器循环遍历集合
        ListIterator<String> itt = list1.listIterator();
        while(itt.hasNext()){
            System.out.print(itt.next()+"");
        }
    }
}
