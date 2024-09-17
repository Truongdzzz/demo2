package com.example.demo2.controller;

import com.example.demo2.model.UserModel;
import com.example.demo2.service.implement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if (session != null&&session.getAttribute("account")!=null) {
//            resp.sendRedirect(req.getContextPath()+"/waiting");
//        }
//
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        UserModel user = userService.login(username, password);
        if(user != null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
