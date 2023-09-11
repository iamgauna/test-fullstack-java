package com.somosetica.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //Indicamos que es una clase de configuracion
@EnableWebSecurity //Habilitamos la seguridad WEB
public class SecurityConfig extends WebSecurityConfigurerAdapter{//WebSecurityConfigurerAdapter utilizaremos para configurar los usuarios que vamos a utilizar
    
    /*/Manejo de los usuarios desde la tablas rol y Usuarios:
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }*/
    
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("eko")
                    .password("{noop}etica")
                    .roles("ADMIN","CONSULTOR")
                .and()
                .withUser("user")
                    .password("{noop}etica")
                    .roles("CONSULTOR");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("CONSULTOR","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403")
                ;
    }
}
