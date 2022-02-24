package com.bit.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-24
 * Time: 18:12
 */
public class TestDemo8 {
    /**
     * 给定一个单词列表words和一个整数 k ，返回前k个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
     * @param words 单词列表
     * @param k 前k个单词
     * @return  前k个出现次数最多的单词
     */
    public static List<String> topKFrequent(String[] words, int k) {
        //1.先统计单词列表中，每个单词出现的次数
        Map<String,Integer> map = new HashMap<>();
        for (String str:words) {
            if(map.get(str) == null){
                //说明该单词是第一次出现
                map.put(str,1);
            }else{
                //不是第一次出现，就使 value 的值 加1
                Integer n = map.get(str);
                map.put(str,n+1);
            }
        }
        //2.建一个小根堆,它的元素类型应该是 key value 的映射关系
        PriorityQueue<Map.Entry<String,Integer>> pr = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                //注意：如果当前堆里的元素有 value 值相同的时候，就需要用大根堆的比较方式，并且比较 key 的值。
                //这样我们后面在  逆序 的时候，结果才会是正确的
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            if(pr.size() < k){
                //先往里面添加 k 个元素
                pr.offer(entry);
            }else{
                //后面的元素，就要与堆里的元素开始比较后，才能入堆

                //先拿到堆顶元素
                Map.Entry<String,Integer> top = pr.peek();
                //然后判断 当单词出现的次数一样的情况
                if(top.getValue().compareTo(entry.getValue()) == 0){
                    //出现频率一样的情况下，按单词入队
                    if(top.getKey().compareTo(entry.getKey()) > 0){
                        pr.poll();
                        pr.offer(entry);
                    }
                }else{
                    //不一样
                    if(top.getValue().compareTo(entry.getValue()) < 0){
                        pr.poll();
                        pr.offer(entry);
                    }
                }
            }
        }
        //3.将存放在堆中的结果放到一个 List 集合中
        List<String> list = new ArrayList<>();
        while(pr.size() > 0){
            Map.Entry<String,Integer> ret = pr.poll();
            list.add(ret.getKey());
        }
        //注意：由于我们建堆时是小根堆，所以，这里我们需要将 list 逆序一下
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list = topKFrequent(words, 2);
        System.out.println(list);
    }
}
