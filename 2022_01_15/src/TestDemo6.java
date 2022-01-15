import java.util.ArrayList;

public class TestDemo6 {
    /**
     * 26. 删除有序数组中的重复项
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums 一组数
     * @return 不重复元素的个数（同时更改原数组的内容）
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length){
            //如果相等，j就继续往下走
            if(nums[i] == nums[j]){
                j++;
                //如果不相等，就在i+1的位置放j当前的元素
            }else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        //下标i+1的值就是不重复的元素个数
        return i+1;
    }
    public static void main(String[] args) {
        int[] num = {1,1,2};
        int n = removeDuplicates(num);
        System.out.println(n);
    }
}
