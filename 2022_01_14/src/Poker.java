import java.util.ArrayList;
import java.util.Random;

/**
 * 每张牌的具体信息
 */
class Card{
    private final int rank;     //数字
    private final String suit;  //花色

    //有参构造，初始化每张牌的内容
    public Card(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }
    //重写toString方法方便以后的打印
    @Override
    public String toString() {
        return "["+this.suit+"::"+this.rank+"]";
    }
}

/**
 * 这是一副扑克牌类
 */
public class Poker {

    //存放着所有牌的花色
    private final String[] data = {"♥","♠","♣","♦"};

    //这是一个买牌方法
    public ArrayList<Card> buyCard() {
        ArrayList<Card> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card(j+1,data[i]);
                list.add(card);
            }
        }
        return list;
    }

    //洗牌
    public void shuffle(ArrayList<Card> cards){
        //从最后一张牌开始洗
        int len = cards.size();
        for (int i = len-1; i > 0 ; i--) {
            Random random = new Random();
            int ret = random.nextInt(i);
            //交换
            swap(cards, i, ret);
        }
    }

    /**
     * 交换两张牌
     * @param cards  牌组
     * @param m  需要交换的牌
     * @param n  需要交换的牌
     */
    private void swap(ArrayList<Card> cards, int m, int n){
        //先获取m位置的牌
        Card ret = cards.get(m);
        //将m位置设置为n位置的对象
        cards.set(m,cards.get(n));
        //将n位置设置为m位置的对象
        cards.set(n,ret);
    }

    /**
     * 这是一个发牌方法
     * @param cards 牌组
     */
    public void Licensing(ArrayList<Card> cards){
        ArrayList<ArrayList<Card>> people = new ArrayList<>();
        //分别存放三个人的牌
        ArrayList<Card> people1 = new ArrayList<>();
        ArrayList<Card> people2 = new ArrayList<>();
        ArrayList<Card> people3 = new ArrayList<>();
        //存放到一个集合里面
        people.add(people1);
        people.add(people2);
        people.add(people3);

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                //每次发最开始的那张牌
                Card ret = cards.remove(0);
                //给到每个人的手中
                people.get(j).add(ret);
            }
        }
        System.out.println("三个人轮流发5张牌：");
        System.out.println(people1);
        System.out.println(people2);
        System.out.println(people3);
        System.out.println("余下的牌：");
        System.out.println(cards);
    }
}
