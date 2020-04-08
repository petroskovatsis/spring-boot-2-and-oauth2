package com.petroskovatsis.examples.springboot2andoauth2.controller.impl;

import com.petroskovatsis.examples.springboot2andoauth2.controller.AuthController;
import com.petroskovatsis.examples.springboot2andoauth2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class AuthControllerImpl implements AuthController {

    private AuthService authService;

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("#oauth2.hasScope('Auth:Logout')")
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public void handleLogoutRequest(OAuth2Authentication authentication) {
        authService.revokeToken(authentication);
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
