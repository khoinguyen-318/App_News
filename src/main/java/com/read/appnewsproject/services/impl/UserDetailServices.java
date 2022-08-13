package com.read.appnewsproject.services.impl;

import com.read.appnewsproject.entity.UserEntity;
import com.read.appnewsproject.model.CustomUserDetails;
import com.read.appnewsproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserDetailServices implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = repository.findByUserName(username);
        userEntity.orElseThrow(()-> new UsernameNotFoundException("UserName not found"+username));
        return userEntity.map(CustomUserDetails::new).get();
    }
}
