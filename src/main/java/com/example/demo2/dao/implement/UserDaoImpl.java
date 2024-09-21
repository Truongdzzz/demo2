package com.example.demo2.dao.implement;
//import com.example.demo2.dao.Interface.UserDao;

import com.example.demo2.ConnectMySQL;
import com.example.demo2.dao.Interface.UserDao;
import com.example.demo2.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    @Override
    public UserModel get(String username) {
        String sql = "select * from user where username=?";
        try {
            connection = (Connection) ConnectMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                UserModel user = new UserModel();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setId(resultSet.getInt("id"));
                user.setCreateDate(resultSet.getDate("createDate"));
                user.setRole(resultSet.getInt("role"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public boolean post(UserModel user1) {
        String sql = "insert into user(username, password, email, role, phone, createDate) values(?,?,?,?,?,?)";
        try {
            connection = (Connection) ConnectMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user1.username);
            preparedStatement.setString(2, user1.password);
            preparedStatement.setString(3, user1.email);
            preparedStatement.setString(4, String.valueOf(user1.role));
            preparedStatement.setString(5, user1.phone);
            preparedStatement.setString(6, String.valueOf(user1.createDate));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
//            return false;
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePassword(String username, String password) {
        UserModel user = get(username);
        String sql = "update user set password=? where id=?";
        try {
            connection = (Connection) ConnectMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
