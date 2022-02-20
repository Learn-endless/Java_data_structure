import java.util.ArrayList;
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
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2147483647);
        list.add(2147483647);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        if (list.get(0).equals(list.get(1))) {

            System.out.println("hello");
        }else{
            System.out.println("jjjjj");
        }
    }
}
