package com.niit.userAuthenticationService.security;

import com.niit.userAuthenticationService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
