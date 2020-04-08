package com.petroskovatsis.examples.springboot2andoauth2.service;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface AuthService {

    void revokeToken(OAuth2Authentication authentication);
}
