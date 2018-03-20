package com.security.template.config.security;

import com.security.template.security.CustomBasicAuthEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.security.template.security.UsersAuthoritiesConstants.USER_AUTHORITY;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private final CustomBasicAuthEntryPoint authEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser(User.builder()
//                        .username("root")
//                        .password("root")
//                        .authorities(USER_AUTHORITY));

        auth.inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder()
                        .username("root")
                        .password("root")
                        .authorities(USER_AUTHORITY));
//    }

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authEntryPoint);

        //when we need com custom filters add here
//        http.addFilterAfter(new CustomFilter(),
//                BasicAuthenticationFilter.class);
    }


}
