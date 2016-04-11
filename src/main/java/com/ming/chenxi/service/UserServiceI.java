package com.ming.chenxi.service;

import com.ming.chenxi.domain.User;
import com.ming.chenxi.domain.UserProfile;
import com.ming.chenxi.exception.UserNotFoundException;

import java.util.List;

/**
 * Created by Ming on 2016/4/9.
 */
public interface UserServiceI {
    //添加用户
    public void addUser(User user);
    //修改用户
    public User updateUser(User user) throws UserNotFoundException;
    //删除用户,根据用户编号删除
    public User deleteUser(int id) throws UserNotFoundException;
    //查询单个用户
    public User getUserById(int id);
    //查询所有用户
    public List<User> getUsers();

    public User getUserByPhone(String phone);

    public UserProfile getUserProfileByUserId(Integer userId);
}
