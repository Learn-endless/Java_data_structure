package com.donghu.learn;
//测试类：用来测试自定义异常类
public class Test {                        //声明，提示调用者。
    public static void func() throws NameException, PassWordException {
        User person = new User("zhangsan","123456");
        if(!person.getName().equals("zhangsan")){ //查看用户名是否相等
            //抛异常
            throw new NameException("用户名异常"); //异常信息
        }
        if(!person.getPassword().equals("888888")){//查看用户密码是否相等
            //抛异常
            throw new PassWordException("用户密码异常");//异常信息
        }
    }
    //调用测试方法
    public static void main(String[] args) {
        try{//用try...catch进行处理
            func();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        System.out.println("程序正常结束！");
    }
}
