package com.meiyu.service.impl;

import com.meiyu.entity.User;
import com.meiyu.dao.UserDao;
import com.meiyu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> queryList() {
        return userDao.queryList();
    }

    @Override
    public User queryByName(String username) {
        return userDao.queryByName(username);
    }

    @Override
    public List<User> searchNameList(String username) {
        return userDao.searchNameList(username);
    }

    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
}