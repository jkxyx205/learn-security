package com.rick.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * WebSecurityConfig 主要用于授权码模式的，用户认证。
 * 如果直接走密码模式，则不需要此类
 * @author Administrator
 * @version 1.0
 **/
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // EnableGlobalMethodSecurity 只能有一个此注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 认证管理器
    // 定义这个Bean，将不显示"Using generated security password: d85b2260-90c9-4bc5-90ad-56ed62bdfead"
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
//                .loginProcessingUrl("/api/login")
//                .successHandler((request, response, authentication) -> {
//                    System.out.println("login success....");
//                    response.getWriter().write("hello");
//                })
                .and()
                .authorizeRequests()
//                .antMatchers("/order/r2").hasAnyAuthority("p2")
//                .antMatchers("/order/r1").permitAll()
                .anyRequest().authenticated()
                ;
    }
}
