package com.bit.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-24
 * Time: 16:12
 */
public class TestDemo7 {
    /**
     * [编程题]旧键盘 (20)
     *
     * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
     * 肯定坏掉的那些键。
     *
     * 输入描述:
     * 输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
     * 以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
     *
     * 输出描述:
     * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
     * @param strExcept 应该输入的字符串
     * @param strActual 实际输入的字符串
     * @return 返回坏键组成的字符串
     */
    public static String func(String strExcept, String strActual){
        //set1 用来存放实际输入的字符
        Set<Character> set1 = new HashSet<>();
        //set2 用来存放坏键字符
        Set<Character> set2 = new HashSet<>();
        //先将实际输入的字符存放到 set1 中
        for(char ch:strActual.toUpperCase().toCharArray()){
            set1.add(ch);
        }
        //定义一个字符串，等下用来接收 坏键 字符
        StringBuilder str = new StringBuilder();
        //遍历预期输入的字符串
        for(char ch:strExcept.toUpperCase().toCharArray()){
            //每拿一个字符就进行判断：
            //该字符在实际输入字符中是不是没有 并且 在存放 坏键 的 set2 中也没有被记录
            if(!set1.contains(ch) && !set2.contains(ch)){
                //满足条件就将该字符放到字符串中，并同时放到 set2 中
                str.append(ch);
                set2.add(ch);
            }
        }
        //返回坏键字符串
        return str.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //多组输入
        while(sc.hasNextLine()){
            String strExcept = sc.nextLine();
            String strActual = sc.nextLine();
            //调用寻找坏键的方法
            String str = func(strExcept,strActual);
            //打印坏键字符串
            System.out.println(str);
        }
    }
}
