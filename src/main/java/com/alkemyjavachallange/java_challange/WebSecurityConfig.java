package com.alkemyjavachallange.java_challange;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource)
                .usersByUsernameQuery("select user_name, password, enabled from user where user_name=?")
                .authoritiesByUsernameQuery("select user_name, role from user where user_name=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN").antMatchers("/user/*").hasRole("USER")
                .antMatchers("/css/login.css").permitAll().antMatchers("/images/alkemylogo.png").permitAll()
                .anyRequest().authenticated().and().formLogin().permitAll().loginPage("/login").and().logout()
                .permitAll();

        http.csrf().disable();

    }
}