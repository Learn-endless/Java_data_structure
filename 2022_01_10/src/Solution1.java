/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，
 * 它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2]
 * 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 */
public class Solution1 {
    public int minArray(int[] numbers) {
        //用来记录左下标
        int left = 0;
        //用来记录右下标
        int right = numbers.length - 1;
        //循环处理，条件 left < right
        while(left < right){
            //记录left与right中心点的下标
            int mid = (left + right) >> 1;
            // right指向的值 > mid指向的值
            if(numbers[right] > numbers[mid]){
                //说明右边是有序的，更新right的指向
                right = mid;
                //right指向的值 < mid指向的值
            }else if (numbers[right] < numbers[mid]){
                //处理left值，重新指向到 mid+1 的位置
                left = mid + 1;
            }else{
                //当right与mid的值相等时，说明出现了重复的数字
                //右下标向前移一位，进行处理
                right--;
            }
        }
        return numbers[left];
    }
}
