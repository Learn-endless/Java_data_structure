public class TestTryCatch {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        try{
            arr[1] = 0;
            arr[2] = 0;
            arr[3] = 0;
            System.out.println("看下程序能否执行到此处！");
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();  // 打印栈轨迹（打印异常信息）
        }
        System.out.println("异常已被处理，程序正常结束！");
    }
}
