package com.rick.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author Administrator
 * @version 1.0
 **/
//@Configuration
//@EnableResourceServer
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    public static final String RESOURCE_ID = "res1";

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID)// 资源id
                .tokenStore(tokenStore)
//                .tokenServices(tokenService())//验证令牌的服务
                .stateless(true);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                .formLogin()
//                .loginProcessingUrl("/api/login")
//                .successHandler((request, response, authentication) -> {
//                    System.out.println("login success....");
//                    response.getWriter().write("hello");
//                })
//                .and()
                .authorizeRequests()
                .antMatchers("/order/r2").hasAnyAuthority("p2")
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                // 需要身份认证的时候跳转的URL（可以直接指定html）
        ;
    }

    //资源服务令牌解析服务
    /* @Bean
    public ResourceServerTokenServices tokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        RemoteTokenServices service=new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:53020/uaa/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }*/

}
