package com.meiyu.service;

import com.meiyu.entity.Book;
import java.util.List;


public interface BookService {


    List<Book> queryList();


    List<Book> queryByKind(String kind);


    Book queryById(Integer id);


    List<Book> queryAllByLimit(int offset, int limit);


    Book insert(Book book);


    Book update(Book book);


    boolean deleteById(Integer id);

}