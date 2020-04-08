package com.petroskovatsis.examples.springboot2andoauth2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Service;
import com.petroskovatsis.examples.springboot2andoauth2.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthorizationServerTokenServices defaultAuthorizationServerTokenServices;
    private ConsumerTokenServices consumerTokenServices;

    @Override
    public void revokeToken(OAuth2Authentication authentication) {
        OAuth2AccessToken accessToken = defaultAuthorizationServerTokenServices.getAccessToken(authentication);
        consumerTokenServices.revokeToken(accessToken.getValue());
    }

    @Autowired
    public void setConsumerTokenServices(ConsumerTokenServices consumerTokenServices) {
        this.consumerTokenServices = consumerTokenServices;
    }

    @Autowired
    public void setDefaultAuthorizationServerTokenServices(AuthorizationServerTokenServices defaultAuthorizationServerTokenServices) {
        this.defaultAuthorizationServerTokenServices = defaultAuthorizationServerTokenServices;
    }
}
