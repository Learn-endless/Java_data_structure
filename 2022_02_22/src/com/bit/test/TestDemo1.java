package com.bit.test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-02-22
 * Time: 23:20
 */

/**
 * 有时候我们为了一个类能够通用（存放不同类型的数据）
 * 我们可以创建一个类，里面有一个 Object 类型的数组
 * 同时也拥有 set 和 get 方法
 */
class MyArray{
    // object 类型的数组
    private final Object[] objects = new Object[10];
    // set 方法
    public void set(int pos, Object val){
        this.objects[pos] = val;
    }
    // get 方法 （注意：这里的 get 方法，返回值是一个 Object 类型的数据，所以在接收时也需要使用 Object 类型的变量接收）
    public Object get(int pos){
        return this.objects[pos];
    }
}

/**
 * 通过上面的例子，可以看到那样写就会有许多弊端
 * 所以就出现了泛型类
 *
 * 这里的 T 代表这是一个泛型类，我们也可以将这里的 T 看成一个 占位符
 * 泛型：就是我们可以将数据的类型当作参数传递
 * 擦除机制：一个泛型类在 编译期 时，编译器会将 T 都擦成 Object ，这就是在编译期会发生的擦除机制（泛型类）
 */
class MyArray1<T>{

    //在将上面的代码改成一个泛型类时，出现了第一个问题：
    // 我们不能直接 new 一个泛型类型的数组
    //private final T[] objects = new T[10];            // error
    private final T[] objects = (T[])new Object[10];    // 这种写法虽然不报错了，但本质上也是不允许的

    public void set(int pos, T val){
        this.objects[pos] = val;
    }

    public T get(int pos){
        return this.objects[pos];
    }

    public T[] getArray(){
        return this.objects;
    }
}

/**
 * 确定了这个泛型的上界为 Number（数字父类）
 * 如果一个泛型类，如： MyArray1 不指定它的上界，那么它默认的上界就是 Object  相当于： T extends Object
 * @param <T> 泛型类
 */
class MyArray2<T extends Number>{

    //在将上面的代码改成一个泛型类时，出现了第一个问题：
    // 我们不能直接 new 一个泛型类型的数组
    //private final T[] objects = new T[10];            // error
    private final T[] objects = (T[])new Object[10];    // 这种写法虽然不报错了，但本质上也是不允许的

    /*
    正确的创建泛型数组的方法，就是使用 反射 来创建一个泛型数组，在反射中可以指定数组的类型
     */

    public void set(int pos, T val){
        this.objects[pos] = val;
    }

    public T get(int pos){
        return this.objects[pos];
    }

    public T[] getArray(){
        return this.objects;
    }
}

/**
 * 定义一个泛型类，找出数组中的最大值
 * @param <T> 泛型类
 *
 * 这里出现了一个特殊的 上界 ，表示 我们所传的类型必须实现了 Comparable 接口
 */
class Alg<T extends Comparable<T>>{
    /**
     * 这是一个泛型方法：找到数组中的最大值
     * @param array 源数组
     * @return  最大值
     */
    public T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            //这里在进行比较时，由于 T 必定实现了 Comparable 接口，所以需要使用 compareTo 来进行比较大小
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }
}



class Alg2{
    /**
     * 当我们将上面的 findMax 改成一个静态的泛型方法时，需要注意：
     * 因为 静态的方法不依赖于对象(也就是不需要 new 对象，然后通过 new 出的对象来调用)
     * 从而这时 T 不是通过实例化对象来 传递 具体类型的，导致 在 findMax 中不能识别 T 的数据类型
     * 所以我们需要在静态方法上对 T 的类型进行指定
     * 又因为我们在这个方法中用到了 compareTo 方法来比较大小，所以我们需要给 所传的类型 指定一个 上界
     * 最终就成了以下的形式：
     */
    public static <T extends Comparable<T>> T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            //这里在进行比较时，由于 T 必定实现了 Comparable 接口，所以需要使用 compareTo 来进行比较大小
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }
}

public class TestDemo1 {

    public static void main(String[] args) {
        Integer[] data = {1,2,3,4,199,88,99,120};
        //如果我们需要自己指定 类型 就可以采用这种写法
        Integer max = Alg2.<Integer>findMax(data);          //直接通过类名来调用静态的泛型方法（少了一次 new 对象）
        //不写其实也是一样的，编译器可以通过我们所传的实参，来推导出 泛型的数据类型
        //Integer max = Alg2.findMax(data);
        System.out.println(max);
    }

    public static void main5(String[] args) {
        Alg<Integer> alg = new Alg<>();
        Integer[] data = {1,2,3,4,199,88,99,120};
        Integer ret = alg.findMax(data);
        System.out.println(ret);
    }

    public static void main4(String[] args) {
        //由于我在泛型中确定了泛型的上界为 Number ，所以我这里在实例化的时候，不能传 String 过去
        MyArray2<Integer> myArray2 = new MyArray2<>();
        MyArray2<Float> myArray21 = new MyArray2<>();   // 可以传 Number 的子类
        MyArray2<Number> myArray22 = new MyArray2<>();  // 或者 Number 自己
        //MyArray2<String> myArray23 = new MyArray2<String>();
    }

    public static void main3(String[] args) {
        MyArray1<Integer> myArray1 = new MyArray1<>();
        myArray1.set(0,10);
        //Integer[] data = myArray1.getArray();   //报错，编译器提示我们不安全
        Object[] data = myArray1.getArray();      //不报错，使用 Object[] 接收
    }

    public static void main2(String[] args) {
        //实例化一个泛型类，其中我们指定 里面存放的元素类型只能是 Integer 类型
        //注意：简单类型（int float double long）不能作为泛型类型的参数，只能使用 类类型
        MyArray1<Integer> myArray1 = new MyArray1<>();

        myArray1.set(0,10);
        //这里可以看到当我们想添加不是 Integer 类型的元素时，编译器报错了
        //myArray1.set(1,"hello world");
        //myArray1.set(2,3.1415);

        Integer number = myArray1.get(0);    //我们在获取值时也不用强制类型转换了

        /*
        所以从上面这段代码可以看出，使用泛型的好处：
        1. 编译器可以自己对元素类型检查
        2. 在获取元素时，编译器自己进行类型的转换
         */
        System.out.println(number);

        /*
        裸类型：
        虽然 MyArray1 是一个泛型类，但是 如果 我们使用 裸类型 实例化，我们就会发现我们的泛型不起作用了，又什么类型的数据都可以放了
         */
        MyArray1 myArray11 = new MyArray1();
        myArray11.set(0,"hello world");
        myArray11.set(1,10);
        myArray11.set(2,3.1415);
    }


    public static void main1(String[] args) {
        MyArray myArray = new MyArray();
        myArray.set(0,"hello world");
        myArray.set(1,10);
        myArray.set(2,3.1415);
        //这里出现的第一个问题：   我创建的这个类，里面可以同时存放 String 、 int 、 double
        //虽然我想创建一个通用的类，但是在一个实体类中就可以存放不同的数据，那这也太通用了

        String str = (String)myArray.get(0);
        //第二个问题：   我在数组的 0 下标存放的是一个字符串，所以在这里用 String 类型的 str 接收，结果报错
        //想要不报错，就必须进行强制类型转换

        System.out.println(str);
    }
}
