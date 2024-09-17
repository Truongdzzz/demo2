package com.example.demo2.service.implement;

import com.example.demo2.dao.Interface.UserDao;
import com.example.demo2.dao.implement.UserDaoImpl;
import com.example.demo2.model.UserModel;
import com.example.demo2.service.Interface.UserService;
import com.example.demo2.dao.Interface.UserDao;
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

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserModel user = new UserModel();
        user = userService.login("truongdz","123456");
    }
}
