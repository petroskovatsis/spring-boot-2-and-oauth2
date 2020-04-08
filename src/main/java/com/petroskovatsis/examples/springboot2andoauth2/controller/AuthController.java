package com.petroskovatsis.examples.springboot2andoauth2.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface AuthController {

    void handleLogoutRequest(OAuth2Authentication authentication);
}
