import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-15
 * Time: 19:00
 */
public class ShellSort {
    /**
     * 希尔排序：缩小增量法
     * 对直接插入排序进行优化
     * 时间复杂度[和增量有关]：O(N^1.3 - N^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的
     *
     * 如果一个排序，在过程中发生了跳跃式的交换，那么这个排序就是不稳定的
     *
     * @param array 待排序数组
     * @param gap 分成的组数
     */
    public static void shell(int[] array, int gap){
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0 ; j-=gap) {
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    //分组
    public static void shellSort(int[] array){
        int gap = array.length/2;
        while(gap > 1){
            shell(array,gap);
            gap /= 2;
        }
        shell(array,1);
    }

    public static void main(String[] args) {
        int[] data = {98,78,14,54,67,89,10,25,30,55};
        shellSort(data);
        System.out.println(Arrays.toString(data));
    }
}
