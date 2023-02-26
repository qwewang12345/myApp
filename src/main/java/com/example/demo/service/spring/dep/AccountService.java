package com.example.demo.service.spring.dep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaonan1
 * @date 2021/5/10 21:44
 **/
@Service
public class AccountService {

    @Autowired
    private AccountController accountController;

}
