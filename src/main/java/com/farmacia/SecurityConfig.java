/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farmacia;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Pablo")
                    .password("{noop}123")
                    .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("Daniel")
                    .password("{noop}456")
                    .roles("VENDEDOR","USER")
                .and()
                .withUser("Jose")
                    .password("{noop}789")
                    .roles("USER");
    }
    
    /*@Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/expediente/lista", "/expediente/modificar", 
                             "/item/lista",       "/item/modificar",
                             "/user/lista",       "/user/modificar"
                             )
                    .hasRole("ADMIN")
                .antMatchers("/expediente/lista", "/item/lista",
                             "/user/lista")
                    .hasAnyRole("ADMIN","VENDEDOR")
                .antMatchers("/")
                    .hasAnyRole("USER","VENDEDOR","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    } */
}
