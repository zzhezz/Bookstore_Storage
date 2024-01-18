package com.meiyu.service;

import com.meiyu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    List<User> queryList();

    User queryByName(String username);

    List<User> searchNameList(@Param("username") String username);

    User queryById(Integer id);

    List<User> queryAllByLimit(int offset, int limit);

    User insert(User user);

    User update(User user);

    boolean deleteById(Integer id);

}