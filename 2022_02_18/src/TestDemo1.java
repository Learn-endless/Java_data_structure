import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-18
 * Time: 23:05
 */
public class TestDemo1 {
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add(2147483647);
//        list.add(2147483647);
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        if (list.get(0).equals(list.get(1))) {
//
//            System.out.println("hello");
//        }else{
//            System.out.println("jjjjj");
//        }
        list.add(100);
        list.add(100);
        list.add(300);
        list.add(300);

        if(list.get(0) .equals(list.get(1)) ){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        if(list.get(2) .equals(list.get(3)) ){
            System.out.println("Yes !!!");
        }else{
            System.out.println("No!!!");
        }
    }

    /**
     * 计数排序：
     * 时间复杂度：O(N)
     * 空间复杂度：O(M) M代表待排序序列中数据的范围
     * 稳定性：稳定的
     * 原因：我们可以定义一个顺序数组，里面用来存放相同元素出现的顺序，让我们在排序时，能够保持原先在前面的排序后也在前面
     * @param array 待排序序列
     */
    public static void countingSort(int[] array){
        //先求出待排序序列中的最小值与最大值
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if(minValue > array[i]){
                minValue = array[i];
            }
            if(maxValue < array[i]){
                maxValue = array[i];
            }
        }

        //创建一个新的数组，用来统计待排序列中元素出现的个数
        int[] count = new int[maxValue - minValue + 1];
        //遍历统计
        for (int x : array) {
            count[x - minValue]++;
        }
        //用来控制原数组的下标
        int index = 0;
        //将遍历的数组覆盖掉原数组
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                array[index] = i+minValue;
                index++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {45,24,65,78,92,14,22,55,22,36,47};
        countingSort(data);
        System.out.println(Arrays.toString(data));
    }

}
