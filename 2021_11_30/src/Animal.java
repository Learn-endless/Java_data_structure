//这是一个interface关键字修饰的接口
public interface Animal {
    //public static final 修饰的属性常量。
    public static final String name = "小黄";

    //接口中只能有抽象方法
    public abstract void eat();

    //或者default修饰的方法
    default void run(){

    }
    //或者是静态方法
    public static void cry(){
        System.out.println("叫声");
    }
}
