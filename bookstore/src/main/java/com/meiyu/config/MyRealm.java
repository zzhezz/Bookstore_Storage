package com.meiyu.config;

import com.meiyu.entity.User;
import com.meiyu.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;

public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("------------------------------->Authorized by MyRealm");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //Get the login usr info
        User user = (User)principals.getPrimaryPrincipal();
        //get the permissions(separated by '-')
        String[] perm = user.getPerm().split("-");

        HashSet<String> set = new HashSet<>(Arrays.asList(perm));
        info.setStringPermissions(set);
        //Add permission
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("------------------------------->Authorized by MyRealm");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();

        User user = userService.queryByName(username);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
