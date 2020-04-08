package com.petroskovatsis.examples.springboot2andoauth2.dto;

import com.petroskovatsis.examples.springboot2andoauth2.domain.Role;

import java.util.Set;

public class AccountDto {

    private Long id;
    private String username;
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
