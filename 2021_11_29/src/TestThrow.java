public class TestThrow {
    public static void main(String[] args) {
        //用try...catch包裹起来，进行处理。
        try{
            test();
        }catch (ArrayIndexOutOfBoundsException e){
            //打印一下异常的信息
            e.printStackTrace();
        }
        System.out.println("异常处理完毕，程序正常结束！");
    }
    //通过throws声明一下异常类型，提示调用者可能会有异常抛出
    public static void test() throws ArrayIndexOutOfBoundsException{
        int[] arr = {1, 2, 3};
        for (int i = 0; i < 5; i++) {
            if (i >= arr.length) {
                //这里可以给一个字符串，用来提示下是什么异常
                throw new ArrayIndexOutOfBoundsException("数组下标越界！");
            }
        }
    }
}




