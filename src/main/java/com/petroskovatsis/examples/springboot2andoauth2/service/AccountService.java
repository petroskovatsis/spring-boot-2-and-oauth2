package com.petroskovatsis.examples.springboot2andoauth2.service;

import com.petroskovatsis.examples.springboot2andoauth2.dto.AccountDto;
import com.petroskovatsis.examples.springboot2andoauth2.dto.AccountSecuredDto;
import com.petroskovatsis.examples.springboot2andoauth2.utils.AccountCreateRequest;

public interface AccountService {

    AccountDto createAccount(AccountCreateRequest request);

    AccountSecuredDto getAccount(String username);
}
