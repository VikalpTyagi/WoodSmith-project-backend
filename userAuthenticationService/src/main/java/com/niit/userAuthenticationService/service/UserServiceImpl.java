package com.niit.userAuthenticationService.service;

import com.niit.userAuthenticationService.domain.User;
import com.niit.userAuthenticationService.exception.InvalidCredentialsException;
import com.niit.userAuthenticationService.exception.UserAlreadyExistException;
import com.niit.userAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistException();
        }
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String userName,String password) throws InvalidCredentialsException {
        User checkUser=userRepository.findByEmailAndPassword(userName,password);
        if(checkUser==null){
            throw new InvalidCredentialsException();
        }
        return checkUser;
    }
}
