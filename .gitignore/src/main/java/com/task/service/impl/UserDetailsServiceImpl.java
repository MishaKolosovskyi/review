package com.task.service.impl;

import com.task.model.User;
import com.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
/*
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByProfileName(s);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}


 */