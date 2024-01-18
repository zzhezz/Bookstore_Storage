package com.meiyu.dao;

import com.meiyu.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface BookDao {

    @Select("select * from book")
    List<Book> queryList();

    List<Book> queryByKind(@Param("kind") String kind);

    Book queryById(Integer id);

    List<Book> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Book> queryAll(Book book);

    int insert(Book book);

    int update(Book book);

    int deleteById(Integer id);
}