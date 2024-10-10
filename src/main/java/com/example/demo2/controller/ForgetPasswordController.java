package com.example.demo2.controller;

import com.example.demo2.model.UserModel;
import com.example.demo2.service.implement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/forgetpassword")
public class ForgetPasswordController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/forgetpassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String newPassword = req.getParameter("newPassword");
        UserServiceImpl userService = new UserServiceImpl();
        UserModel userModel = new UserModel();
        userModel = userService.get(username);
        if(userModel.getPassword().equals(password)){
            boolean check = userService.updatePassword(username, newPassword);
            if(check){
                req.getRequestDispatcher("views/login.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("alert", "Invalid name or password");
            }
        }
    }
}
