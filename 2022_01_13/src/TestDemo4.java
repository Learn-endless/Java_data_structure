public class TestDemo4 {
    /**
     * 自定义一个方法，判断一个字符串是不是回文的
     * 例：abcba ： true
     */
    public static boolean judge(String str){
        //记录左下标
        int left = 0;
        //记录右下标
        int right = str.length()-1;
        //循环判断
        while(left < right){
            //相等下一组
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                //有一组不相等直接结束循环
                return false;
            }
        }
        //走到这里说明是回文的
        return true;
    }


    public static void main(String[] args) {
        String str = "aaaa";
        System.out.println(judge(str));
    }
}
