package com.somosetica.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //Indicamos que es una clase de configuracion
@EnableWebSecurity //Habilitamos la seguridad WEB
public class SecurityConfig extends WebSecurityConfigurerAdapter{//WebSecurityConfigurerAdapter utilizaremos para configurar los usuarios que vamos a utilizar
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("eko")
                    .password("{noop}etica")
                    .roles("ADMIN","USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("USER","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403")
                ;
    }
}
