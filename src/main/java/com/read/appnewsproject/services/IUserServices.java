package com.read.appnewsproject.services;

import com.read.appnewsproject.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserServices {
    List<UserDTO> getAllUser(Pageable pageable);

    UserDTO addNewAccount(UserDTO userDTO);

    void deleteUser(Long id);

    UserDTO getById(Long id);

    UserDTO updateUser(UserDTO newUser, Long id);
}
