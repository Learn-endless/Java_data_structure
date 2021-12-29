package com.learn.java.test1;
import java.util.Arrays;
import java.util.Scanner;
public class Test_1 {
    public static int func(int[] arr, int n){
        //输入多少数字，就拷贝多少个数字
        int[] tmp = Arrays.copyOf(arr, n);
        //先来排序
        Arrays.sort(tmp);
        //重复的肯定在一起
        for (int i = 0; i < n-1; i++) {
            if(tmp[i] == tmp[i+1]){
                //找到了一个重复数字
                //直接返回该数字
                return tmp[i];
            }
        }
        //没有返回一个-399
        return -399;
    }

    public static void main(String[] args) {
        //用来存放一组数
        int[] arr = new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        //输入数组中的数
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ret = func(arr, n);
        if(ret == -399){
            System.out.println("没有重复的数！");
        }else{
            System.out.println("重复的数为："+ret);
        }
    }
}
