package com.read.appnewsproject.audit;

import com.read.appnewsproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class AuditAwareImpl implements AuditorAware<String> {
    @Autowired
    private UserRepository repository;
    @Override
    public Optional<String> getCurrentAuditor() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.ofNullable(repository.getFullName(userName));
    }
}
