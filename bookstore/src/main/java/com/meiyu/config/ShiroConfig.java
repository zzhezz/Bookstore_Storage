package com.meiyu.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        LinkedHashMap<String, String> filtermap = new LinkedHashMap<>();


        filtermap.put("/*/*.js", "anon");
        filtermap.put("/*/*.css", "anon");
        filtermap.put("*.html", "anon");
        filtermap.put("/tologin", "anon");
        filtermap.put("/login", "anon");
        filtermap.put("/index", "authc");
        filtermap.put("/logout", "logout");
        filtermap.put("/**", "authc");


        bean.setFilterChainDefinitionMap(filtermap);


        bean.setLoginUrl("/login");
        //set the webpage after successfully login
        bean.setSuccessUrl("/index");
        //set non-authorized page
        bean.setUnauthorizedUrl("/noauth");
        return bean;

    }

    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
