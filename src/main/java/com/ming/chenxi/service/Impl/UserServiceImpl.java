package com.ming.chenxi.service.Impl;

import com.ming.chenxi.domain.User;
import com.ming.chenxi.domain.UserProfile;
import com.ming.chenxi.exception.UserNotFoundException;
import com.ming.chenxi.repository.UserProfileRepository;
import com.ming.chenxi.repository.UserRepository;
import com.ming.chenxi.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ming on 2016/4/9.
 */
@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void addUser(User user) {
        if(user!=null)
            userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        User userUpdate = userRepository.findOne(user.getUserId());
        if (userUpdate==null)
            throw new UserNotFoundException();
        if(user.getPhone()!=null)
            userUpdate.setPhone(user.getPhone());
        userRepository.save(userUpdate);
        return userUpdate;
    }

    @Override
    public User deleteUser(int id) throws UserNotFoundException {
        User userDelete = userRepository.findOne(id);
        if (userDelete==null)
            throw new UserNotFoundException();
        userRepository.delete(userDelete);
        return userDelete;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findOne(id);
    }

    public User getUserByPhone(String username){
        return userRepository.findByPhone(username);
    }

    @Override
    public UserProfile getUserProfileByUserId(Integer userId) {
        return userProfileRepository.getUserProfileByUserId(userId);
    }

    public UserProfile getUserProfileByPhone(String phone){
        return userProfileRepository.getUserProfileByPhone(phone);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /*private String EncryUtil(String str){
        if(!StringUtils.isEmpty(str)){
            *//*ShaPasswordEncoder sha = new ShaPasswordEncoder();
            sha.setEncodeHashAsBase64(false);
            String encryStr = sha.encodePassword(str, null);*//*
            return encryStr;
        }
        throw null;
    }*/
}
