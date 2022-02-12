import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-12
 * Time: 14:46
 */

class Card{
    public int rank;
    public String suit;
    public Card(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
/*
自定义 rank 比较器
 */
class RankComparator implements Comparator<Card>{
    @Override
    public int compare(Card o1, Card o2) {
        /*
        在源码中是拿当前的对象减去parent指向的对象
        if(comparator.compare(x, (E) e) >= 0) break;
        所以 o2 - o1 是大根堆
            o1 - o2 是小根堆
         */
        return o2.rank - o1.rank;
    }
}

public class TestDemo3 {
    public static void main1(String[] args) {
        MyHeap m = new MyHeap();
        int[] data = {98,87,75,99,68,40,84,88,15,29};
        m.creatHeap(data);
        m.headSort();
        System.out.println("=========");
    }

    public static void main(String[] args) {
        Card card1 = new Card(1,"♥");
        Card card2 = new Card(2,"♥");
        //该比较器是用来比较 Card 中的 rank 大小
        RankComparator rankComparator = new RankComparator();
        //创建优先级队列时，可以直接传一个自定义比较器
        PriorityQueue<Card> p = new PriorityQueue<>(rankComparator);
        p.offer(card1);
        p.offer(card2);
        //重写 toString 方法后可以直接打印
        System.out.println(p);
    }
}
