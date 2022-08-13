package com.read.appnewsproject.services.impl;

import com.read.appnewsproject.dto.UserDTO;
import com.read.appnewsproject.entity.UserEntity;
import com.read.appnewsproject.repository.UserRepository;
import com.read.appnewsproject.services.IUserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements IUserServices {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUser(Pageable pageable) {
        return repository.findAll(pageable)
                .map(User -> modelMapper.map(User, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO addNewAccount(UserDTO userDTO) {
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        repository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }
    @Override
    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
