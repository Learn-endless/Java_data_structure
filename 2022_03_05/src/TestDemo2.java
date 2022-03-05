/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-05
 * Time: 21:40
 */

/**
 * 学习枚举
 * 自定义枚举类 都是默认继承 Enum 类
 * 同时编译器在编译时,都会插入 一个静态方法 public staticT[] values()
 * All the constants of an enum type can be obtained by calling the implicit {@code public static T[] values()} method of that type.
 */
public enum TestDemo2 {
    //这三个都是 枚举 对象,第一调用了 有参的构造方法,后面两个都是调用的无参构造方法
    RED("red",1),YELLOW("yellow",2),GREEN("green",3);

    public String color;
    public int id;

    //枚举类型的 构造方法 都默认是 私有的, 所以 不能加 public 或者 加不加 private 都一样
    private TestDemo2(String color,int id){
        this.color = color;
        this.id = id;
    }

    private TestDemo2(){

    }

    public static void main(String[] args) {
        //main方法如果在 枚举类 里面,可以直接使用,或者用 类名.枚举属性 使用
        System.out.println(RED);
        System.out.println(TestDemo2.YELLOW);
    }
}
