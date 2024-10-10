package com.example.demo2.controller;

import com.example.demo2.model.UserModel;
import com.example.demo2.service.implement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null&&session.getAttribute("username")!=null) {
            resp.sendRedirect(req.getContextPath()+"/profile");
            return;
        }
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if(cookie.getName().equals("username")) {
//                    session = req.getSession(true);
//                    session.setAttribute("username", cookie.getValue());
//                    resp.sendRedirect(req.getContextPath()+"/waiting");
//                    return;
//                }
//            }
//        }
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        UserModel user = userService.login(username, password);
        HttpSession session = req.getSession(false);
        if(user != null) {
            session.setAttribute("username", username);
            req.getRequestDispatcher("views/profile.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("alert", "Invalid username or password");
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }
    }
}
