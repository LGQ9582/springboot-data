package com.li.config;

import com.li.mapper.UserMapper;
import com.li.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm{


    @Autowired
    UserMapper userMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");


        //拿到当前User用户对象
        Subject subject = SecurityUtils.getSubject();
         User user = (User) subject.getPrincipal();

         //设置当前用户权限，从数据库查出来
         info.addStringPermission(user.getPerms());
        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String name = "admin";
        String password = "111";

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.findUserByName(token.getUsername());


        if(user==null){//没有这个用户
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("loginUser",user);

        //密码认证,shiro自己做
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");

        //
    }
}
