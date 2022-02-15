import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-15
 * Time: 13:43
 */
public class TestSort {
/*
    直接插入排序：
    时间复杂度：最坏的情况：O(N^2)
              最好的情况：O(N)
    空间复杂度：O(1)
    稳定性：稳定的
    定义：一个本身稳定的排序，可以变成不稳定的；但一个本身就不稳定的排序，是不可以变成稳定的
    特性：数组本身越趋近于有序，该排序方法则越快
 */
    public static void insertSort(int[] array){
        //i遍历整个数组
        for(int i = 1; i < array.length; i++){
            //记录下当前 i 下标所对应的值
            int tmp = array[i];
            //j 从 i-1 开始往后循环判断
            int j = i-1;
            for (; j >= 0; j--) {
                //如果 j 指向的值大于当前 i 指向的值，将 j 指向的值往后偏移
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    //出现等于或小于的情况，直接 break
                    break;
                }
            }
            // 在这里就可以处理三种情况：
            //        1. j 下标的值小于 i 下标的值
            //        2. j 下标的值等于 i 下标的值
            //        3. j 下标为负数时
            array[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] data = {98,78,14,54,67,89,10,25,30,55};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }
}
