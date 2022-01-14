import java.util.ArrayList;

/**
 * 用集合的方式打印杨辉三角形
 */
public class Pascaltriangle {
    public static void main(String[] args) {
        int n = 10;  //需要打印杨辉三角形的行数
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        //第一行为固定的1
        ArrayList<Integer> list1 = new ArrayList<>();
        //添加第一行的元素1
        list1.add(1);
        //将第一行添加到data中
        data.add(list1);

        for(int i = 1; i < n; i++){
            //用来存放每一行的具体内容
            ArrayList<Integer> list = new ArrayList<>();
            //添加头元素
            list.add(1);
            //拿到上一行的数据
            ArrayList<Integer> ret = data.get(i-1);
            for (int j = 1; j < i; j++) {
                //得到当前需要存放的值
                int tmp = ret.get(j)+ret.get(j-1);
                list.add(tmp);
            }
            //这一行为元素为1
            list.add(1);
            //将这一行的内容添加到data中
            data.add(list);
        }
        //打印每行的内容
        for (ArrayList<Integer> x:data) {
            System.out.println(x);
        }
    }
}
