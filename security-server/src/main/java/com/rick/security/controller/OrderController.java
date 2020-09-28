package com.rick.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("order")
@RestController
public class OrderController {

    @GetMapping("r1")
    public String r1() {
        return "这里是r1资源";
    }

    @GetMapping("r2")
    public String r2() {
        return "这里是r2资源";
    }

    @PreAuthorize("hasAuthority('p3')")//拥有p3权限方可访问此url
    @GetMapping("r3")
    public String r3() {
        return "这里是r3资源";
    }

    @PreAuthorize("hasAuthority('p4')")//拥有p4权限方可访问此url
    @GetMapping("r4")
    public String r4() {
        return "这里是r3资源";
    }
}
