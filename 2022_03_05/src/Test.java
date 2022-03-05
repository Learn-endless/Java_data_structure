import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-03-05
 * Time: 20:54
 */

/**
 * 学习反射机制
 */
public class Test {

    public static void main(String[] args) {
        try {
            //1.获取类类型
            Class<?> p = Class.forName("Person");
            //2.获取 run 方法(有参数时,在后面添加上参数类型)
            Method method = p.getDeclaredMethod("run",String.class);
            //3.将修改私有的权限
            method.setAccessible(true);
            //4.实例化一个对象(共有的无参构造方法)
            Person person = (Person) p.newInstance();

//            //获取私有的无参构造方法
//            Constructor<?> c = p.getDeclaredConstructor();
//            //更改权限
//            c.setAccessible(true);
//            //实例化对象
//            Person person = (Person) c.newInstance();

            //5.调用私有化的方法
            method.invoke(person,"猪猪侠");

//            System.out.println(person);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main3(String[] args) {
        try {
            Class<?> p = Class.forName("Person");

            Field name = p.getDeclaredField("name");

            //更改私有的权限
            name.setAccessible(true);

            Person person = (Person) p.newInstance();

            name.set(person,"午安无");

            System.out.println(person);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public static void main2(String[] args) {

        try {
            //1.获取类
            Class<?> p = Class.forName("Person");
            //2.获取构造方法(对应的类型)
            Constructor<?> constructor = p.getDeclaredConstructor(String.class, int.class);
            //3.更改权限,让我们可以 实例化私有的对象
            constructor.setAccessible(true);
            //4.调用构造方法,实例化对象
            Person person = (Person)constructor.newInstance("王五", 23);


            System.out.println(person);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static void main1(String[] args)  {
        try {
            //1.先获取类
            Class<?>person = Class.forName("Person");
            //2.创建类的实例(创建了一个对象)
            Person p = (Person) person.newInstance();

            System.out.println(p);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
