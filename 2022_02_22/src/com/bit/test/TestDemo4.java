package com.bit.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-23
 * Time: 23:41
 */
public class TestDemo4 {
    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public static int singleNumber(int[] nums) {
        //用一个 set 集合来存放数据
        Set<Integer> set = new HashSet<>();
        //循环遍历，如果发现重复，就从 set 集合中 remove
        for(int x:nums){
            if(set.contains(x)){
                set.remove(x);
            }else{
                //没有，就添加到 set 集合中
                set.add(x);
            }
        }
        //将最后 set 集合中的数据存放到数组中
        Object[] n = set.toArray();
        //唯一不重复的数据就是当前数组中的第一元素
        return (int)n[0];

        //也可以使用迭代器来输出那个不重复的数
//        Iterator<Integer> iterator = set.iterator();
//        Integer x = 0;
//        while(iterator.hasNext()){
//            x = iterator.next();
//        }
//        return x;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,1,2,3,4,6,7,8,9};
        int ret = singleNumber(data);
        System.out.println(ret);
    }
}
