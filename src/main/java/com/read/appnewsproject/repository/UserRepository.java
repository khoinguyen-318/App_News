package com.read.appnewsproject.repository;

import com.read.appnewsproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUserName(String username);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "select u.fullname from tbl_user u where u.username = ?1",nativeQuery = true)
    String getFullName(String username);
}
