package com.meiyu.dao;

import com.meiyu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao {

    @Select("select * from user")
    List<User> queryList();

    User queryByName(@Param("username") String username);

    @Select("select * from user where username = #{username}")
    List<User> searchNameList(@Param("username") String username);

    User queryById(Integer id);

    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<User> queryAll(User user);

    int insert(User user);

    int update(User user);

    int deleteById(Integer id);

}