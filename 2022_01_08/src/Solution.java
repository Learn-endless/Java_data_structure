/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //首先判断matrix数组是不是null或者是一个没有元素的二维数组
        if(matrix == null || matrix.length == 0){
            return false;
        }
        //列指针，初始指向为矩阵的第一行的最后一个元素
        int col = matrix[0].length - 1;
        //行指针，初始指向第一行
        int row = 0;
        //循环条件为当前二维数组有效下标范围内
        //即：row不能大于矩阵的行数，col不能为负数
        while(row < matrix.length && col >= 0){
            //如果row这行中最大的数还比target小
            if(matrix[row][col] < target){
                //直接与下一行最大的数进行比较
                row++;
            //如果比row这一行中最大的数小，则向左移动col，在这一行中查找
            }else if(matrix[row][col] > target){
                //每次向左移动一位，然后进行比较
                col--;
            }else{
                //相等，即找到了，返回true
                return true;
            }
        }
        //走到这里，说明没找到，则返回false
        return false;
    }
}
