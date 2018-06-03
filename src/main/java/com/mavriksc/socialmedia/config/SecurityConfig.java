package com.mavriksc.socialmedia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
           .authorizeRequests()
               .antMatchers("/**").permitAll()
           .and()
               .authorizeRequests()
               .antMatchers("/h2-console/**").permitAll();

       // these things are needed to use the console
        // and at least the 1(one) matcher above and maybe the other one too.
       http.csrf().disable();
       http.headers().frameOptions().disable();
    }
}
