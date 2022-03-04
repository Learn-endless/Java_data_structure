import java.time.Period;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-04
 * Time: 21:25
 */


class Person{
    public String id;

    public Person(String str){
        this.id = str;
    }

    /**
     * 使用自定义类 来 做 HashMap 的 key 时,需要在自己类中重写 HashCode 和 equals 方法    --------(特别注意)
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {   // equals 确定链表中具体的某一个值
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {             // HashCode 确定链表的头节点位置
        return Objects.hash(id);
    }
}


/**
 * (复习 巩固)
 * 使用泛型,来创建一个 哈希桶
 */
public class HashBuck2 <K,V>{
    static class Node<K,V>{
        public K key;
        public V value;
        public Node<K,V> next;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
    private Node<K,V>[] array;
    private int usedSize;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    public HashBuck2(){
        this.array = new Node[10];
    }

    public void put(K key, V value){
        int index = key.hashCode()%this.array.length;

        //2.再处理一下如果在当前的 哈希表 中存在 key 的值,那么我们需要 对 它的 value 值进行更新
        Node<K,V> cur = this.array[index];
        while(cur != null){
            //使用 equals 确定具体的值
            if(cur.key.equals(key)){
                //更新value
                cur.value = value;
                //这次插入结束
                return;
            }
            cur = cur.next;
        }

        //3.走到这里说明没有 key 的值,可以进行添加元素了.
        Node<K,V> node = new Node<>(key,value);
        //使用头插法 插入该元素
        node.next = this.array[index];
        this.array[index] = node;
        this.usedSize++;

        //4.每次插入完数据后,就需要检查一下负载因子,看看是不是需要扩容
        if(checkLoadFactor()){
            //说明需要扩容了
            arrayDilatation();
        }
    }

    public V get(K key){
        int index = key.hashCode()%this.array.length;

        Node<K,V> cur = this.array[index];
        while(cur != null){
            //使用 equals 确定具体的值
            if(cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 扩容方法
     */
    private void arrayDilatation(){
        Node<K,V>[] tmp = new Node[this.array.length*2];
        //有了一块空间之后,我们就需要进行二次哈希
        for (Node<K,V> cur:this.array) {
            while(cur != null){
                //计算当前元素在 tmp 中应该存放位置的下标
                int index = cur.key.hashCode()%tmp.length;
                //头插法插入
                Node<K,V> curNext = cur.next;   //记录一下 cur 的下一个元素的 地址
                cur.next = tmp[index];
                tmp[index] = cur;
                cur = curNext;             //往下一个元素走
            }
        }
        this.array = tmp;
    }

    /**
     * 检查当前哈希表是否需要扩容
     * @return  一个boolean值
     */
    private boolean checkLoadFactor(){
        return 1.0 * this.usedSize / this.array.length > DEFAULT_LOAD_FACTOR;
    }

    public static void main(String[] args) {
        Person person1 = new Person("10010");
        Person person2 = new Person("10010");

        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1,"aaa");
        hashBuck2.put(person2,"bbb");
        System.out.println(hashBuck2.get(person1));
        //通过结果可以看到 , 在 哈希表 中, person1 和 person2 其实是一个地方,添加 person2 才会将 person1 的值给修改掉
    }
}
