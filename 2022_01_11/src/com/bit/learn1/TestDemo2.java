package com.bit.learn1;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class TestDemo2 {
    //剑指 Offer 58 - II. 左旋转字符串
    public String reverseLeftWords(String s, int n) {
        //计算旋转前几个字符
        n %= s.length();
        //以n为分界点，分成两个字符串处理
        String l = s.substring(0, n);
        String r = s.substring(n, s.length());
        //前半部分字符串逆序
        StringBuilder l1 = new StringBuilder(l);
        l1 = l1.reverse();
        //后半部分字符串逆序
        StringBuilder r1 = new StringBuilder(r);
        r1 = r1.reverse();
        //两部分拼接在一起
        l1.append(r1);
        //拼接后的字符串再次整体逆序
        l1 = l1.reverse();
        //用String类型返回结果
        return new String(l1);

    }

    //查找重复的数，剑指offer
    public int findRepeatNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            if(list.contains(nums[i])){
                return nums[i];
            }else{
                list.add(nums[i]);
            }
        }
        return -1;
    }
}
