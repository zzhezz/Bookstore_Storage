package com.meiyu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiyu.entity.Book;
import com.meiyu.service.BookService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Resource
    private BookService bookService;


    @GetMapping("selectList")
    public String selectList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size){
        PageHelper.startPage(pn, size);
        List<Book> books = bookService.queryList();
        PageInfo<Book> page = new PageInfo<>(books);
        model.addAttribute("page",page);
        return "book/book-list";
    }

    @GetMapping("to-book-add")
    public String toBookAdd() {
        return "book/book-add";
    }

    @PostMapping("add")
    public String add(Book book) {
        bookService.insert(book);
        return "redirect:/book/selectList";
    }

    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        bookService.deleteById(id);
        return "redirect:/book/selectList";
    }

    @GetMapping("to-book-edit/{id}")
    public String toAdminEdit(@PathVariable("id") Integer id, Model model) {
        Book editbook = bookService.queryById(id);
        model.addAttribute("editbook", editbook);
        return "book/book-edit";
    }

    @PostMapping("update")
    public String update(Book book) {
        bookService.update(book);
        return "redirect:/book/selectList";
    }

    @GetMapping("toSearchList/{kind}")
    public String toSearchList(@PathVariable("kind") String kind, Model model,@RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "5") int size){
        //trim the space
        String skind = StringUtils.deleteWhitespace(kind);
        PageHelper.startPage(pn, size);
        List<Book> books = bookService.queryByKind(kind);
        PageInfo<Book> page = new PageInfo<>(books);
        model.addAttribute("page",page);
        return "book/book-list";
    }

    @GetMapping("selectOne")
    public Book selectOne(Integer id) {
        return this.bookService.queryById(id);
    }


}