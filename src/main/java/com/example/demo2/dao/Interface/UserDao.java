package com.example.demo2.dao.Interface;
import com.example.demo2.model.UserModel;
public interface UserDao {
    UserModel get(String username);
    boolean post(UserModel user);
}
