package com.petroskovatsis.examples.springboot2andoauth2.service.impl;

import com.petroskovatsis.examples.springboot2andoauth2.domain.Account;
import com.petroskovatsis.examples.springboot2andoauth2.domain.Role;
import com.petroskovatsis.examples.springboot2andoauth2.dto.AccountDto;
import com.petroskovatsis.examples.springboot2andoauth2.dto.AccountSecuredDto;
import com.petroskovatsis.examples.springboot2andoauth2.repository.AccountRepository;
import com.petroskovatsis.examples.springboot2andoauth2.service.AccountService;
import com.petroskovatsis.examples.springboot2andoauth2.utils.AccountCreateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private ModelMapper modelMapper;
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public AccountDto createAccount(AccountCreateRequest request) {
        Account account = new Account();
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRoles(Set.of(Role.ROLE_USER));
        accountRepository.save(account);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    @Transactional
    public AccountSecuredDto getAccount(String username) {
        Optional<Account> optionalAccount = accountRepository.findByUsername(username);
        Account account = optionalAccount.orElseThrow(() -> new RuntimeException("Account not found."));
        return modelMapper.map(account, AccountSecuredDto.class);
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
