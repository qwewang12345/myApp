package com.example.demo.service.spring.dep;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gaonan1
 * @date 2021/5/10 21:40
 **/
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    // 构造函数依赖注入
    // 不管是否设置为required为true，都会出现循环依赖问题
//    public AccountController(AccountService accountService) {
//        this.accountService = accountService;
//    }

}
