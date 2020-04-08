package com.petroskovatsis.examples.springboot2andoauth2.controller;

import com.petroskovatsis.examples.springboot2andoauth2.dto.AccountDto;
import com.petroskovatsis.examples.springboot2andoauth2.utils.AccountCreateRequest;
import org.springframework.http.ResponseEntity;

public interface AccountController {

    ResponseEntity<AccountDto> handleCreateRequest(AccountCreateRequest request);
}
