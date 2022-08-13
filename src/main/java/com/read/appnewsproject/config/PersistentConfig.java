package com.read.appnewsproject.config;

import com.read.appnewsproject.audit.AuditAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class PersistentConfig {
    @Bean
    public AuditorAware<String> auditorProvider(){
        return new AuditAwareImpl();
    }
}
