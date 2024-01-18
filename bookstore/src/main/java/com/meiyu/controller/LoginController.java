package com.meiyu.controller;

import com.meiyu.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping({"login", "/"})
    public String login() {
        return "login";
    }

    @PostMapping("tologin")
    public String tologin(User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user1 = (User) subject.getPrincipal();
            subject.getSession().setAttribute("user", user1);
            return "redirect:/index";

        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "wrong username");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "wrong password");
            return "login";
        } catch (ExcessiveAttemptsException e) {
            model.addAttribute("msg", "Excessive Attempts!");
            return "login";
        } catch (LockedAccountException e) {
            model.addAttribute("msg", "Account Locked. The account for username " + token.getPrincipal() + " was locked.");
            return "login";
        } catch (DisabledAccountException e) {
            model.addAttribute("msg", "Banned Account. The account for username " + token.getPrincipal() + " was disabled.");
            return "login";
        } catch (ExpiredCredentialsException e) {
            model.addAttribute("msg", "Expired Account. the account for username " + token.getPrincipal() + "  was expired.");
            return "login";
        } catch (UnauthorizedException e) {
            model.addAttribute("msg", "Unauthorized Account！" + e.getMessage());
            return "login";
        }
    }

    @GetMapping("index")
    public String toindex() {
        return "index";
    }

    @GetMapping("/noauth")
    public String noauth() {
        return "noauth";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

}
