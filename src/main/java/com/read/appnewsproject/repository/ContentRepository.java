package com.read.appnewsproject.repository;

import com.read.appnewsproject.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentEntity,Long> {
}
