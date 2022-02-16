import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-16
 * Time: 14:19
 */
public class TestSort {
    /**
     * 选择排序，优化后的
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的
     * @param array 待排序序列
     */
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            //找到 i 下标后面元素中的最小元素下标
            int minIndex = i+1;
            for (int j = minIndex+1; j < array.length ; j++) {
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //将 minIndex 指向的最小元素与 i 下标的元素进行比较
            if(array[i] > array[minIndex]){
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的
     * @param array 待排序序列
     */
    public static void selectSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 堆排序(从小到大的顺序)
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的
     * @param array 待排序序列
     */
    public static void heapSort(int[] array){
        //建大根堆
        //时间复杂度：O(N)
        createHeap(array);
        int end = array.length - 1;
        while(end > 0){
            //交换
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            //向下调整
            shiftDown(array,0,end);
            //下一组
            end--;
        }
    }

    /**
     * 建大根堆
     * @param array 数据
     */
    public static void createHeap(int[] array){
        for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--) {
            //每棵树都向下调整
            shiftDown(array,parent,array.length);
        }
    }

    /**
     * 向下调整
     * @param array 操作的数据
     * @param parent 父亲节点
     * @param len 调整的范围
     */
    private static void shiftDown(int[] array, int parent, int len){
        int child = parent*2+1;
        while(child < len){
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[parent] < array[child]){
                //交换
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
                //更新 parent 与 child 的值
                parent = child;
                child = parent*2+1;
            }else{
                //说明已经有序了
                break;
            }
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(N^2)  ，不管待排序序列本身是否有序，都是O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定的
     * @param array 待排序序列
     */
    public static void bubbleSort(int[] array){
        //排序的趟数
        for(int i = 0; i < array.length-1; i++){
            //每趟交换的次数
            for(int j = 0; j < array.length-1; j++){
                if(array[j] > array[j+1]){
                    //交换
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序(进行优化)
     * 时间复杂度：O(N^2)
     * 最好的情况下：O(N)
     * 空间复杂度：O(1)
     * 稳定性：稳定的
     * @param array 待排序序列
     */
    public static void bubbleSort2(int[] array){
        //排序的趟数
        for(int i = 0; i < array.length-1; i++){
            //用来标记，判断序列此时是否有序
            boolean flg = true;
            //每趟交换的次数
            for(int j = 0; j < array.length-1-i; j++){
                if(array[j] > array[j+1]){
                    //交换
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //只要交换一次，就标记一下
                    flg = false;
                }
            }
            //如果走到这里 flg 还是 true ，说明前面没有进行过交换，此时序列已经有序
            if(flg){
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：
     * 空间复杂度：O(N)
     * 稳定性：不稳定的
     *
     * @param array
     */
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    private static void quick(int[] array, int start, int end){
        //递归结束条件
        if(start >= end){
            return;
        }
        //找基准
        int pivotIndex = pivotIndex(array,start,end);
        //递归左边
        quick(array,start,pivotIndex-1);
        //递归右边
        quick(array,pivotIndex+1,end);
    }

    //找基准(挖坑法)
    private static int pivotIndex(int[] array, int start, int end){
        //拷贝一份 start 下标指向的元素
        int tmp = array[start];
        while(start < end){
            //先从后往前找，找比基准小的数
            while(start < end && array[end] >= tmp){   //注意：如果这里不加等号，待排序列中若是出现相同的数，就会出现死循环。
                end--;                                 //同时，加了等号后，就需要加一个条件： start < end，不然就会出现数组下标越界异常
            }
            //将找到的数，放到基准的左边
            array[start] = array[end];
            //从前往后找，找比基准大的数
            while(start < end && array[start] <= tmp){
                start++;
            }
            //大的数放到基准的右边
            array[end] = array[start];
        }
        //当 start 与 end 相等时，就将基准放到该位置，并返回基准的下标
        array[start] = tmp;
        return start;
    }


    public static void main(String[] args) {
        int[] data = {1,2,2,4,5,6,7,8,9,10,11};
//        selectSort1(data);
//        heapSort(data);
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }

    //给一组有序序列，观察选择排序的排序时间
    public static void test1(int capacity){
        int[] data = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = i;
        }
        //开始排序的时间（毫秒）
        long start = System.currentTimeMillis();
        //selectSort(data);     //优化过的
        selectSort1(data);      //没优化的
        //结束时的时间（毫秒）
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    //给一组无序序列，观察选择排序的时间
    public static void test2(int capacity){
        int[] data = new int[capacity];
        Random random = new Random();
        for(int i = 0; i < capacity; i++){
            data[i] = random.nextInt(capacity);
        }
        //开始排序的时间（毫秒）
        long start = System.currentTimeMillis();
        //selectSort(data);     //优化过的
        selectSort1(data);      //没有优化过的
        //结束时的时间（毫秒）
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main2(String[] args) {
        test1(10_0000);
        test2(10_0000);
        /*
        测试结果：
        虽然测试的比较粗糙，但还是可以明显看出优化过的在排序无序序列时还是更快些
         */
    }
}
