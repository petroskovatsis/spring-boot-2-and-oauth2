package com.petroskovatsis.examples.springboot2andoauth2.security;

import com.petroskovatsis.examples.springboot2andoauth2.dto.AccountSecuredDto;
import com.petroskovatsis.examples.springboot2andoauth2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailsManager implements UserDetailsService {

    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountSecuredDto accountSecuredDto = accountService.getAccount(username);
        return buildUserFor(accountSecuredDto);
    }

    private User buildUserFor(AccountSecuredDto accountSecuredDto) {
        Set<GrantedAuthority> authorities = new HashSet();
        accountSecuredDto.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.name())));

        return new User(accountSecuredDto.getUsername(), accountSecuredDto.getPassword(), authorities);
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
