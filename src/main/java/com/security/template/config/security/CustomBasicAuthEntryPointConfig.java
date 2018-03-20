package com.security.template.config.security;

import com.security.template.security.CustomBasicAuthEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBasicAuthEntryPointConfig {

    @Bean
    CustomBasicAuthEntryPoint authEntryPoint() {
        return new CustomBasicAuthEntryPoint();
    }
}
