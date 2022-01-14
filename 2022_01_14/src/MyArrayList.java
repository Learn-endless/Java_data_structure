import java.util.Arrays;

/**
 * 参照原码写一个ArrayList
 */
public class MyArrayList<E> {
    private Object[] elementData;
    private int userSize;
    //数组的最大容量
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //定义一个成员变量，后面直接使用。
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //定义一个成员变量，值为10，用来第一次扩容
    private static final int DEFAULT_CAPACITY = 10;

    //无参初始化顺序表
    public MyArrayList(){
        this.elementData = EMPTY_ELEMENTDATA; //初始化大小为0
    }
    //有参初始化顺序表的大小
    public MyArrayList(int initialCapacity){
        //正常的初始化值，直接创建大小
        if(initialCapacity > 0){
            elementData = new Object[initialCapacity];
        //当为0时，直接给一个空数组
        }else if(initialCapacity == 0){
            elementData = EMPTY_ELEMENTDATA;
        //小于0时，直接抛出异常
        }else{
            throw new IllegalArgumentException("初始化顺序表的大小不能为负数！");
        }
    }
    //添加元素
    public boolean add(E e) {
        //检查当前的空间大小是否足够大
        ensureCapacityInternal(userSize + 1);
        //放到当前顺序表的末尾
        elementData[userSize++] = e;
        return true;
    }

    /**
     * 该方法用来判断当前空间是否足够大
     * @param minCapacity 需要满足的空间大小
     */
    private void ensureCapacityInternal(int minCapacity){
        //先计算当前需要多大的空间
        int capacity = calculateCapacity(elementData, minCapacity);
        //确定扩容空间的大小
        ensureExplicitCapacity(capacity);
    }

    private int calculateCapacity(Object[] elementData,int minCapacity){
        //如果是第一次扩容
        if(elementData == EMPTY_ELEMENTDATA){
            //返回10
            return DEFAULT_CAPACITY;
        }
        //不是第一次，需要多大返回多大的空间
        return minCapacity;
    }

    /**
     * 该方法确定扩容的大小
     * @param minCapacity 需要的空间大小
     */
    private void ensureExplicitCapacity(int minCapacity) {
        //如果需要的空间大小大于当前数组的长度，就进行扩容
        if (minCapacity - elementData.length > 0)
            //调用扩容方法
            grow(minCapacity);
    }

    /**
     * 这是具体的扩容方法
     * @param minCapacity
     */
    private void grow(int minCapacity){
        //原先数组的容量
        int oldCapacity = elementData.length;
        //1.5倍扩容,得到新的容量
        int newCapacity = oldCapacity+(oldCapacity >> 1);
        //判断新容量与所需要的容量的大小关系
        if(newCapacity - minCapacity < 0){
            //新容量比需要的还要小，直接更新新容量
            newCapacity = minCapacity;
        }
        //数组的元素个数是有一个极限的：Integer.MAX-8
        if(newCapacity - MAX_ARRAY_SIZE > 0){
            //如果当前的新容量超出了MAX_ARRAY_SIZE，说明需要重新计算newCapacity的值
            newCapacity = hugeCapacity(minCapacity);
        }
        //扩容
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity){
        //先判断所需要的容量是否合法
        if(minCapacity < 0){
            //抛出一个异常
            throw new OutOfMemoryError("扩容大小为负！");
        }
        //与int的最大值减8进行比较:
        //minCapacity大，那我只能给你最大的扩容量：Integer.MAX_VALUE（int的最大值）
        //minCapacity小，那给你Integer.MAX_VALUE-8就够了。
        return (minCapacity > MAX_ARRAY_SIZE)? Integer.MAX_VALUE:MAX_ARRAY_SIZE;
    }

    /**
     * 根据下标插入数据
     * @param index   下标
     * @param element  所插入的数据
     */
    public void add(int index, E element) {
        //检查下标的合法性
        rangeCheckForAdd(index);
        //确认数组的容量是否够大
        ensureCapacityInternal(userSize + 1);
        //挪数据
        System.arraycopy(elementData, index, elementData, index + 1, userSize - index);
        //插入数据
        elementData[index] = element;
        userSize++;
    }

    /**
     * 该方法用来判断插入的位置是否合法
     * @param index 想要插入的位置
     */
    private void rangeCheckForAdd(int index){
        //为负数或大于userSize，抛出一个异常
        if(index < 0 || index > userSize){
            throw new IndexOutOfBoundsException("下标不合法！");
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", userSize=" + userSize +
                '}';
    }
}
