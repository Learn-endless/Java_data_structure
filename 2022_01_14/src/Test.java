import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {
    //测试一下扑克牌类里的方法
    public static void main(String[] args) {
        Poker poker = new Poker();
        //买牌
        ArrayList<Card> card = poker.buyCard();
        System.out.println("买来的牌：");
        System.out.println(card);
        //洗牌
        poker.shuffle(card);
        System.out.println("洗牌：");
        System.out.println(card);
        //发牌
        poker.Licensing(card);
    }

    public static void main1(String[] args) {
        MyArrayList<String> m = new MyArrayList<>(5);
        m.add("hello");
        m.add("bit");
        m.add("bit");
        m.add("bit");
        m.add("bit");
        m.add("bit");
        System.out.println(m);
    }
}
