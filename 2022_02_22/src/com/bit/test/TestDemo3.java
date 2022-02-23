package com.bit.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-23
 * Time: 21:05
 */
public class TestDemo3 {

    /**
     * 统计一组数据中，每个数据重复出现的次数
     * @param array 给定一组数据
     * @return 返回每个数据对应重复的次数
     */
    public static Map<Integer,Integer> func1(int[] array){
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : array) {
            if (map.containsKey(x)) {
                int n = map.get(x);
                map.put(x,n+1);
            } else {
                map.put(x, 1);
            }
        }
        return map;
    }

    /**
     * 对一组数进行去重处理
     * @param array 一组数据
     * @return 返回去重后的数据
     */
    public static Set<Integer> func2(int[] array){
        Set<Integer> set = new HashSet<>();
        for (int x:array) {
            set.add(x);
        }
        return set;
    }

    /**
     * 返回一组数据中第一次重复的数据
     * @param array 一组数据
     * @return 返回第一次重复的数
     *
     * 返回值设置为 Integer ，如果没有重复的数，就可以返回 null
     */
    public static Integer func3(int[] array){
        Set<Integer> set = new HashSet<>();
        for (int x:array) {
            if(set.contains(x)){
                return x;
            }else{
                set.add(x);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //随机10000个数据，放到一个数组中
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        int[] data = {1,1,1,2,3,4,5,6,7,8,9,1,1,1};
        //统计数据重复的次数
        Map<Integer,Integer> map = func1(array);
        //打印统计后的结果
        System.out.println(map);
        //将数据去重
        Set<Integer> set = func2(array);
        System.out.println(set);
        //找第一次重复的数据
        Integer n = func3(array);
        if(n == null){
            System.out.println("没有重复的数");
        }else{
            System.out.println(n);
        }

    }

    public static void main1(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //当 key 值重复的话，会直接将以前的值覆盖掉
        map.put("bit",3);
        map.put("bit",2);
        map.put("bit",1);
        System.out.println(map.get("bit"));
        //当 key 值重复的话，会直接将以前的值覆盖掉
        Map<String,Integer> map1 = new TreeMap<>();
        map1.put("hello", 3);
        map1.put("hello", 2);
        map1.put("hello", 0);
        System.out.println(map1.get("hello"));

        //在 Set 中只会存放不重复的数据
        Set<Integer> set = new HashSet<>();
        set.add(9);
        set.add(8);
        set.add(10);
        set.add(9);
        System.out.println(set);
        //在 Set 中只会存放不重复的数据
        Set<Integer> set1 = new TreeSet<>();
        set1.add(9);
        set1.add(2);
        set1.add(9);
        set1.add(7);
        System.out.println(set1);
    }
}
