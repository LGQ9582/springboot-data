package com.li.config;


//开启 SecurityConfig
//@EnableWebSecurity
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/{

/*
    //链式编程
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //首页所有人可以访问，功能页只有对应有权限的人才可以访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限跳到登录页面，
        http.formLogin().loginPage("/toLogin").usernameParameter("name").passwordParameter("password").loginProcessingUrl("/login");

        //注销,开启注销功能

        http.csrf().disable();//关闭csrf()功能
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remenber");

    }


    //在spring security 5.0+中新增了很多的加密方式
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("li4").password(new BCryptPasswordEncoder().encode("111")).roles("vip1","vip3")
                .and()
                .withUser("wang5").password(new BCryptPasswordEncoder().encode("111")).roles("vip2","vip3");

    }*/
}
