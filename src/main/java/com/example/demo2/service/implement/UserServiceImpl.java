package com.example.demo2.service.implement;

import com.example.demo2.dao.Interface.UserDao;
import com.example.demo2.dao.implement.UserDaoImpl;
import com.example.demo2.model.UserModel;
import com.example.demo2.service.Interface.UserService;
import com.example.demo2.dao.Interface.UserDao;

import java.util.Date;

public class UserServiceImpl implements UserService {
    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.get(username);
        if(user.getPassword().equals(password)&&user!=null) {
            return user;
        }
        return null;
    }
    @Override
    public UserModel get(String username){
        UserDao userDao = new UserDaoImpl();
        return userDao.get(username);
    }
    @Override
    public boolean post(UserModel user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.post(user);
    }

    @Override
    public boolean checkExistsUsername(String username) {
        if(this.get(username)!=null) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserModel user = new UserModel();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        user.setRole(1);
        user.setPhone("09991123");
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        user.setCreateDate(date);
        boolean result = userService.post(user);
        if(result){
            System.out.print("OK");
        }
        else System.out.print("FAIL");
    }
}
