/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-05
 * Time: 22:40
 */

/**
 * 如何实现一个线程安全的单例模式(只能获取对象的一个实例)???
 * 通过枚举来实现单例模式.
 */
public enum Singleton {
    INIT;

    public void doSomething1(){
        System.out.println("做一些事...");
    }
    public void doSomething2(){
        System.out.println("再做一些事...");
    }
    public void doSomething3(){
        System.out.println("还要做一些事...");
    }

    //使用
    public static void main(String[] args) {
        Singleton.INIT.doSomething1();
        Singleton.INIT.doSomething2();
        Singleton.INIT.doSomething3();
    }
}
