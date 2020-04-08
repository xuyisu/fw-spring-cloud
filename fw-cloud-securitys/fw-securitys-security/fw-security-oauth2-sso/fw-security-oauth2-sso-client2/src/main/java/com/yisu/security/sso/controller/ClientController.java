package com.yisu.security.sso.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@RestController
public class ClientController {

    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/normal")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String normal() {
        return "这是用户正常权限访问的数据";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "这是需要管理员权限才可以访问的数据，访问会报403";
    }





}
