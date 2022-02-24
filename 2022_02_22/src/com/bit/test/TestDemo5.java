package com.bit.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-24
 * Time: 14:31
 */
public class TestDemo5 {
    /**
     * 771. 宝石与石头
     * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
     * stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *
     * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
     * @param jewels 宝石
     * @param stones 石头
     * @return 返回宝石出现的次数
     */
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        //将宝石的字符串放到 set 集合中
        for(int i = 0; i < jewels.length(); i++){
            //拿到字符串中的每个字符
            char ch = jewels.charAt(i);
            set.add(ch);
        }
        //计数器
        int count = 0;
        //遍历统计宝石在石头中出现的次数
        for(int i = 0; i < stones.length(); i++){
            char ch = stones.charAt(i);
            //通过contains方法判断当前字符是否在 set 集合中
            if(set.contains(ch)){
                count++;
            }
        }
        //返回出现的次数
        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "abBBBaAATtGh";
        int total = numJewelsInStones(jewels,stones);
        System.out.println(total);
        char ch = 'a';
        char c = (char) (ch - ' ');
        StringBuilder str = new StringBuilder();
    }
}
