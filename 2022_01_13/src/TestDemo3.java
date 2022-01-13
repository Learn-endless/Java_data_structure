public class TestDemo3 {
    /**
     * 自定义实现开算术平方根方法
     * @param x 输入一个整数
     * @return 输入它的算术平方根
     */
    public static int sqrt(int x){
        int left = 1;  //左边界
        int right = x; //右边界
        //指向同一个数时也需要判断一次
        while(left <= right){
            //计算中间数
            int mid = (left+right)>>1;
            //直接找到，返回mid
            if(x/mid == mid){
                return mid;
                //找到最近的数，也返回
            }else if(x/mid > mid && x/(mid+1) < (mid+1)){
                return mid;
                //mid太大的情况，更新right
            }else if(mid > x/mid){
                right = mid - 1;
                //mid+1太小的情况，更新left
            }else{
                left = mid + 1;
            }
        }
        //输入的数为0的情况
        return 0;
    }

    public static void main(String[] args) {
        int a = 255;
        int ret = sqrt(a);
        System.out.println(ret);
    }
}
