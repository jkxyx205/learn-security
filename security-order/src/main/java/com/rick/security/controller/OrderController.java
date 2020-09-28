package com.rick.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/25/20 10:42 PM
 * @Copyright: 2020 www.yodean.com. All rights reserved.
 */
@RequestMapping
@RestController
public class OrderController {

    @GetMapping("r1")
    public String r1(@RequestHeader("Authorization") String token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "这里是order中的r1资源, authentication.getPrincipal()" + authentication.getPrincipal() + "token:" + token;
    }

    @GetMapping("r2")
    @PreAuthorize("hasAuthority('pp')")
    public String r2(@RequestHeader("Authorization") String token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "这里是order中的r1资源, authentication.getPrincipal()" + authentication.getPrincipal() + "token:" + token;
    }
}
