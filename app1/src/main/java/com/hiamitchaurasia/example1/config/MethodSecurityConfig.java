package com.hiamitchaurasia.example1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true)
public class MethodSecurityConfig
        extends GlobalMethodSecurityConfiguration {
}
