package com.meiyu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meiyu.entity.User;
import com.meiyu.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("selectList")
    public String selectList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(pn, size);
        List<User> users = userService.queryList();
        PageInfo<User> page = new PageInfo<>(users);
        model.addAttribute("users", users);
        model.addAttribute("page", page);
        return "user/admin-list";
    }

    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        userService.deleteById(id);
        return "redirect:/user/selectList";
    }

    @GetMapping("to-admin-add")
    public String toAdminAdd() {
        return "user/admin-add";
    }

    @GetMapping("to-admin-edit/{id}")
    public String toAdminEdit(@PathVariable("id") Integer id, Model model) {
        User edituser = userService.queryById(id);
        model.addAttribute("edituser", edituser);
        return "user/admin-edit";
    }

    @PostMapping("add")
    public String add(User user) {
        userService.insert(user);
        return "redirect:/user/selectList";
    }

    @PostMapping("update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/user/selectList";
    }

    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @GetMapping("usernameSearch/{username}")
    public String usernameSearch(@PathVariable("username") String username, Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "5") int size){
        //trim space
        String name = StringUtils.deleteWhitespace(username);
        PageHelper.startPage(pn, size);
        //username is unique
        List<User> userList = userService.searchNameList(name);
        PageInfo<User> page = new PageInfo<>(userList);
        model.addAttribute("page",page);
        return "user/admin-list";
    }

    /**
     * Check if the username is already exist or not when created
     * @param username
     * @return
     */
    @ResponseBody
    @GetMapping("checkexist/{username}")
    public String checkexist(@PathVariable("username") String username){
        User user = userService.queryByName(username);
        if(user != null){
            return "exist";
        }else {
            return "noexist";
        }
    }
}