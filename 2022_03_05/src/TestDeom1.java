import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-05
 * Time: 15:05
 */

/**
 * 自定义一个 类 用来 使用反射
 */
class Person{
    private String name = "zhangsan";
    public int age = 18;

    public Person(){
        System.out.println("Person()");
    }
    private Person(String s, int age){
        this.name = s;
        this.age = age;
    }

    public void eat(){
        System.out.println("吃饭了");
    }
    private void sleep(){
        System.out.println("睡觉了");
    }

    private void run(String name){
        System.out.println(name+" 跑起来了");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDeom1 {
    public static void main(String[] args) {
        try {
            //1.使用 Class.forName(路径) 获取对象
            Class<?> person1 = Class.forName("Person");
            //2.使用 类名.class 获取对象
            Class<?> person2 = Person.class;
            //3.先 new 一个对象,然后 对象.getClass() 获取对象
            Person person3 = new Person();
            Class<?> person4 = person3.getClass();

            //都是 true ,说明这三种方法 获取的对象 都是同一个
            System.out.println(person1 == person2);
            System.out.println(person1 == person4);
            System.out.println(person4 == person2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
