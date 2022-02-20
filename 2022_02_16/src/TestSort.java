import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

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
     * 时间复杂度：O(N*logN)  两边的数据均匀分割的情况下
     * 最坏的情况下:O(N^2)    数据有序或者是逆序
     * 空间复杂度：O(logN)
     * 最坏的情况下O(N)       是一颗单分支的树时
     * 稳定性：不稳定的
     *
     * @param array 待排序数组
     */
    public static void quickSort(int[] array){
        //递归实现快速排序
//        quick1(array,0,array.length-1);
        //非递归实现
        quick(array,0,array.length-1);
    }


    public static void main(String[] args) {
//        int[] data = {10,99,87,100,45,86,77,99,98,63};
//        selectSort1(data);
//        heapSort(data);
//        quickSort(data);
//        int[] A = {1,2,3,4,5,6};
//        int[] B = {3,4,5,6,7,8,9,10};
        int[] data = {10,85,76,99,98,78,30,46,55,44,44};
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }


    /**
     * 归并排序：
     * 时间复杂度：O(N*logN) 每层的范围是 N ,每层的高度是 logN
     * 空间复杂度：O(N)      tmp 的大小与 array 大小一致
     * 稳定性：稳定的
     * 冒泡、直接插入排序、归并 这三个是 稳定的 排序
     * @param array 待排序序列
     */
    public static void mergeSort(int[] array){
        //为了保持接口的统一，另外定义一个方法来进行递归（递归版本）
//        mergeSortInternal(array,0,array.length-1);


        //非递归版本
        int nums = 1;  //每组元素的个数
        while(nums < array.length){
            //每次都要将整个数组遍历一遍
            for (int i = 0; i < array.length; i += nums*2) {   //每次移动两倍的当前每组的元素个数
                int left = i;
                int mid = left+nums-1;                         //mid 为当前 left + nums - 1
                //判断一下 mid 下标越界没有
                if(mid >= array.length){
                    mid = array.length-1;
                }
                int right = mid+nums;                          //right 为当前 mid + nums
                //判断一下 right 是否越界
                if(right >= array.length){
                    right = array.length-1;
                }
                //下标都没有问题后，调用合并方法
                merge(array,left,mid,right);
            }
            //每次合并后，下次每组元素的个数为前一次的两倍
            nums *= 2;
        }
    }

    /**
     * 用来进行递归的方法
     * @param array 待排序序列
     * @param left 左下标
     * @param right 右下标
     */
    private static void mergeSortInternal(int[] array,int left, int right){
        //递归结束条件
        if(left >= right){
            return;
        }
        //求中间下标
        int mid = left+((right-left) >>> 1);
        //左递归
        mergeSortInternal(array,left,mid);
        //右递归
        mergeSortInternal(array,mid+1,right);
        //合并
        merge(array,left, mid, right);

    }

    /**
     * 合并方法
     * @param array 源数组
     * @param left 左下标
     * @param mid 中间下标
     * @param right 右下标
     */
    private static void merge(int[] array, int left, int mid, int right){
        //用来存放当前合并后的序列
        int[] tmp = new int[right-left+1];
        //待合并的两个序列的范围
        int i = left;
        int j = mid+1;
        //tmp的下标
        int index = 0;
        //先处理元素个数一致的部分
        while(i <= mid && j <= right){
            //将较小的一方放到 tmp 中
            if(array[i] <= array[j]){
                tmp[index++] = array[i++];
            }else{
                tmp[index++] = array[j++];
            }
        }
        //处理第一个序列元素多于的部分
        while(i <= mid){
            tmp[index++] = array[i++];
        }
        //处理第二个序列元素多的部分
        while(j <= right){
            tmp[index++] = array[j++];

        }
        //最后将 tmp 中的数据拷贝到 array 对应的位置
        System.arraycopy(tmp,0,array,left,tmp.length);
    }

    /**
     * 合并两个有序数组
     * @param arrayA 有序数组
     * @param arrayB 有序数组
     * @return 合并后的有序数组
     */
    public static int[] mergeArray(int[] arrayA,int[] arrayB){
        if(arrayB == null){
            return arrayA;
        }else if(arrayA == null){
            return arrayB;
        }

        int i = 0;
        int j = 0;
        int[] array = new int[arrayA.length+arrayB.length];
        int index = 0;

        while(i < arrayA.length && j < arrayB.length){
            //比较当前的两个数，将小的数放到array中
            if(arrayA[i] <= arrayB[j]){
                array[index++] = arrayA[i++];
            }else{
                array[index++] = arrayB[j++];
            }
        }
        //处理 arrayA 长度大于 arrayB 的情况
        while(i < arrayA.length){
            array[index++] = arrayA[i++];
        }
        //出来 arrayB 长度大于 arrayA 的情况
        while(j < arrayB.length){
            array[index++] = arrayB[j++];
        }
        return array;
    }


    //非递归实现
    private static void quick(int[] array,int start,int end){
        Stack<Integer> stack = new Stack<>();
        /*
        对基准的优化：
        使用三数取中法
         */
        int midIndex = findMidIndex(array,start,end);
        //交换 中间数 与 最左边的数
        int tmp = array[midIndex];
        array[midIndex] = array[start];
        array[start] = tmp;
        //找基准
        int pivotIndex = pivotIndex(array,start,end);
        if(pivotIndex > start+1){
            //说明左边至少有两个数据，放下标
            stack.push(start);
            stack.push(pivotIndex-1);
        }
        if(pivotIndex < end-1){
            //说明右边至少也有两个数据，放下标
            stack.push(pivotIndex+1);
            stack.push(end);
        }
        while(!stack.isEmpty()){
            end = stack.pop();
            start = stack.pop();
            /*
            对基准的优化：
            使用三数取中法
            */
            midIndex = findMidIndex(array,start,end);
            //交换 中间数 与 最左边的数
            tmp = array[midIndex];
            array[midIndex] = array[start];
            array[start] = tmp;
            //找基准
            pivotIndex = pivotIndex(array,start,end);
            if(pivotIndex > start+1){
                //说明左边至少有两个数据，放下标
                stack.push(start);
                stack.push(pivotIndex-1);
            }
            if(pivotIndex < end-1){
                //说明右边至少也有两个数据，放下标
                stack.push(pivotIndex+1);
                stack.push(end);
            }
        }
    }

    //递归实现快速排序
    private static void quick1(int[] array, int start, int end){
        //递归结束条件
        if(start >= end){
            return;
        }
        /*
        对快速排序进行优化：
        使用一个门阀，当数据递归到达一个数量时，使用直接插入排序进行处理。
         */
        if(end-start+1 < 5000){
            insertSort(array,start,end);
            //使用直接插入排序完成后，直接返回。
            return;
        }

        /*
        对基准的优化：
        使用三数取中法
         */
        int midIndex = findMidIndex(array,start,end);
        //交换 中间数 与 最左边的数
        int tmp = array[midIndex];
        array[midIndex] = array[start];
        array[start] = tmp;

        //找基准
        int pivotIndex = pivotIndex(array,start,end);   //默认在找基准时，去当前范围的start下标为基准后，当数据太大时，可能会出现栈溢出异常
        //递归左边
        quick(array,start,pivotIndex-1);
        //递归右边
        quick(array,pivotIndex+1,end);
    }

    /*
    对快排进行优化的直接插入排序
     */
    private static void insertSort(int[] array,int start, int end){
        for (int i = start+1; i <= end ; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= start; j--) {
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //三数取中法，对取基准进行优化
    private static int findMidIndex(int[] array,int start,int end){
        //拿到中间下标，用减法防止数据溢出
        int mid = start+((end - start)>>>1);
        //分情况，找到中间的数
        if(array[start] > array[end]){
            if(array[mid] > array[start]){
                return start;
            }else if(array[mid] < array[end]){
                return end;
            }else{
                return mid;
            }
        }else{
            if(array[mid] < array[start]){
                return start;
            }else if(array[mid] > array[end]){
                return end;
            }else{
                return mid;
            }
        }
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


//-----------------------------------------------------------------------------------------
    //给一组有序序列，观察选择排序的排序时间
    public static void test1(int capacity){
        int[] data = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = i;
        }
        //开始排序的时间（毫秒）
        long start = System.currentTimeMillis();
        //selectSort(data);     //优化过的
        //selectSort1(data);      //没优化的
        //快速排序
        quickSort(data);
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

    public static void main1(String[] args) {
        test1(100_0000);
//        test2(10_0000);
        /*
        测试结果：
        虽然测试的比较粗糙，但还是可以明显看出优化过的在排序无序序列时还是更快些
         */
    }
}
