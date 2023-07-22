package com.niit.userAuthenticationService.service;


import com.niit.userAuthenticationService.domain.User;
import com.niit.userAuthenticationService.exception.InvalidCredentialsException;
import com.niit.userAuthenticationService.exception.UserAlreadyExistException;

public interface UserService {
    User saveUser(User user) throws UserAlreadyExistException;
    User loginUser(String userName,String password) throws InvalidCredentialsException;
}
