package com.petroskovatsis.examples.springboot2andoauth2.controller.impl;

import com.petroskovatsis.examples.springboot2andoauth2.controller.AccountController;
import com.petroskovatsis.examples.springboot2andoauth2.dto.AccountDto;
import com.petroskovatsis.examples.springboot2andoauth2.service.AccountService;
import com.petroskovatsis.examples.springboot2andoauth2.utils.AccountCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountControllerImpl implements AccountController {

    private AccountService accountService;

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> handleCreateRequest(@RequestBody AccountCreateRequest request) {
        AccountDto response = accountService.createAccount(request);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
