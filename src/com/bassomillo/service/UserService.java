package com.bassomillo.service;

import com.bassomillo.constant.Constant;
import com.bassomillo.dao.UserDao;
import com.bassomillo.entity.User;

import com.bassomillo.exception.UserIsExistException;
import com.bassomillo.exception.UserIsNotExistException;
import com.bassomillo.exception.WrongPasswordException;
import com.bassomillo.util.MD5Util;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    public void register(User user) {
        //design password
        if(user.getUsername()!=null&& !"".equals(user.getUsername())&&
           user.getPassword()!=null&&!"".equals(user.getPassword())&&
           userDao.select(user.getUsername())==-1){
            String password =  user.getUsername()+user.getPassword()+ Constant.SALT;
            user.setPassword(MD5Util.digest(password));
            userDao.save(user);
        }else{
            throw new UserIsExistException();
        }

    }

    public Boolean CheckUserName(String username) {
        if(userDao.select(username)!=-1){
            return true;
        }else {
            return false;
        }
    }

    public String getProfile(String username) {
        List<User> userByName = userDao.findUserByName(username);
        if(userByName.size()>0){
            return userByName.get(0).getProfile();
        }
        return null;
    }

    public void login(User user) {
        List<User> userByName = userDao.findUserByName(user.getUsername());
        if(userByName.size()==0){
            throw new UserIsNotExistException();
        }
        User user1 = userByName.get(0);
        if(user.getUsername()!=null && user.getPassword()!=null){
            String password =  user.getUsername()+user.getPassword()+ Constant.SALT;
            user.setPassword(MD5Util.digest(password));
            if(!user.getPassword().equals(user1.getPassword())){
                throw new WrongPasswordException();
            }
        }
    }

    public List<User> findAllUsers(Integer currentPage, Integer pageSize) {
        return userDao.findAllUsers(currentPage,pageSize);
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    public Integer update(User user) {
        return userDao.update(user);
    }

    public Integer getUserTotal() {
        return userDao.getUserTotal();
    }
}
