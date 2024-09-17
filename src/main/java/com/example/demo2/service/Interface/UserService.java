package com.example.demo2.service.Interface;

import com.example.demo2.model.UserModel;

public interface UserService {
    public UserModel login(String username, String password);
    public UserModel get(String username);
    public boolean post(UserModel user);
    public boolean checkExistsUsername(String username);
}
