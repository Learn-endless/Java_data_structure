<<<<<<< HEAD
//package com.example.web;
//
//import com.example.bean.User;
//import com.example.service.UserService_1;
//import com.example.service.impl.UserService_1Impl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//    @WebServlet(urlPatterns = "/AddServlet")
//    public class AddServlet extends HttpServlet {
//        UserService_1 userService1 = new UserService_1Impl();
//        @Override
//        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            //获取请求参数
//            String username = req.getParameter("username");
//            String password = req.getParameter("password");
//            String name = req.getParameter("name");
//            String email = req.getParameter("email");
//            String telephone = req.getParameter("telephone");
//            //调用add保存用户
//            userService1.add(new User(null, username, password, name, email, telephone));
//            //跳转到用户列表页面,此方法有表单重复提交
//            //req.getRequestDispatcher("/UserServlet").forward(req, resp);
//
//            //无重复添加
//            resp.sendRedirect("UserServlet");
//        }
//    }
=======
package com.example.web;

import com.example.bean.User;
import com.example.service.UserService_1;
import com.example.service.impl.UserService_1Impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    /**
     * @program: ManageResourceSystem
     * @description: 添加数据的处理业务
     * @author: Mr.Zeng
     * @create: 2021-05-27 08:01
     **/
    @WebServlet(urlPatterns = "/AddServlet")
    public class AddServlet extends HttpServlet {
        UserService_1 userService1 = new UserService_1Impl();
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取请求参数
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String telephone = req.getParameter("telephone");
            //调用add保存用户
            userService1.add(new User(null, username, password, name, email, telephone));
            //跳转到用户列表页面,此方法有表单重复提交
            //req.getRequestDispatcher("/UserServlet").forward(req, resp);

            //无重复添加
            resp.sendRedirect("UserServlet");
        }
    }
>>>>>>> 77c3972cbca5f9503bc7f3ce057b3e9ea814aaae
