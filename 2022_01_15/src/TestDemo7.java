public class TestDemo7 {
    /**
     * 27. 移除元素
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums 一个数组
     * @param val 值
     * @return  返回一个值
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        //循环遍历整个数组
        while(j < nums.length){
            //如果等于val
            if(nums[j] == val){
                //继续往下找
                j++;
            }else{
                //不等于val，将值放到i的位置，i和j都往后面走
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
//        Double a = (double) new Integer(1);
//        Object b = new Integer(1);
//        System.out.println(a);
//        System.out.println("=====");
//        System.out.println(b);
//        System.out.println(14^3);
//        byte a = 127;
//        byte b = 127;
//        b += a;
//        System.out.println(b);
//        System.out.println(-5+1/4+2*(-3)+5.0);
    }
}
