//定义一个图形的父类
abstract class Shape{
    public abstract void print();  //这是一个需要被重写的方法
}

class Triangle extends Shape{
    //重写父类的print方法
    @Override
    public void print() {
        System.out.println("△");
    }
}

class Rectangle extends Shape{
    //重写父类print方法
    @Override
    public void print() {
        System.out.println("□");
    }
}

class Circle extends Shape{
    //重写父类print方法
    @Override
    public void print() {
        System.out.println("○");
    }
}

//使用多态需要满足两个条件
//1.向上转型：父类引用 引用 子类对象
//2.重写父类方法。
public class Test {
    public static void draw(Shape x){   //这里是用父类对象的引用接收
        x.print();
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        //这就发生了多态
        draw(triangle);   //传过去的是子类对象的引用
        draw(rectangle);
        draw(circle);

    }
}
