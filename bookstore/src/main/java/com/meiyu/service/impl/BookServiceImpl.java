package com.meiyu.service.impl;

import com.meiyu.entity.Book;
import com.meiyu.dao.BookDao;
import com.meiyu.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public List<Book> queryList() {
        return bookDao.queryList();
    }


    @Override
    public List<Book> queryByKind(String kind) {
        return bookDao.queryByKind(kind);
    }


    @Override
    public Book queryById(Integer id) {
        return this.bookDao.queryById(id);
    }

    @Override
    public List<Book> queryAllByLimit(int offset, int limit) {
        return this.bookDao.queryAllByLimit(offset, limit);
    }

    @Override
    public Book insert(Book book) {
        this.bookDao.insert(book);
        return book;
    }


    @Override
    public Book update(Book book) {
        this.bookDao.update(book);
        System.out.println("BookServiceImpl"+bookDao.update(book));
        return this.queryById(book.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.bookDao.deleteById(id) > 0;
    }
}