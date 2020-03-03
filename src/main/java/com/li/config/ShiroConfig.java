package com.li.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //shirofilterFactaryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器

        bean.setSecurityManager(defaultWebSecurityManager);
        /*//添加shiro的内置过滤器
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            user:必须拥有记住我才能访问
            perms:拥有某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        Map<String, String> map = new LinkedHashMap<>();

        map.put("/level1/3","perms[user:add]");
        map.put("/level1/1","perms[user:update]");
//        map.put("/level1/1","authc");
        map.put("/level1/2","authc");

        bean.setFilterChainDefinitionMap(map);

        //为授权页面
        bean.setUnauthorizedUrl("/authc");

        //设置登录页面
        bean.setLoginUrl("/toLogin");
        return bean;

    }

    /**
     * 用户管理器
     * @Qualifier("userRealm") 绑定名为userRealm的方法
     * @param userRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建Realm对象,需要自定义类
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect:用来整合 shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
