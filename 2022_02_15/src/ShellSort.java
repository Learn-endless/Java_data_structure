import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-15
 * Time: 19:00
 */
public class ShellSort {
    //希尔排序：缩小增量法
    //对直接插入排序进行优化
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
