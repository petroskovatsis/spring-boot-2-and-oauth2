package com.petroskovatsis.examples.springboot2andoauth2.dto;

public class AccountSecuredDto extends AccountDto {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
