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

    @Override
    public boolean updatePassword(String username, String newPassword) {
        UserDao userDao = new UserDaoImpl();
        return userDao.updatePassword(username, newPassword);
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        boolean check = userService.updatePassword("admin", "11111");
        if(check) {
            System.out.print("OK");
        }
        else {
            System.out.print("NO");
        }
    }
}
