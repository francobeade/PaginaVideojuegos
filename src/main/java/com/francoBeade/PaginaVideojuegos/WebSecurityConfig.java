package com.francoBeade.PaginaVideojuegos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("user")
                .password("qwerty")
                .roles("USER")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("admin")
                .password("qwerty")
                .roles("ADMIN")
                .build());
        return manager;
    }
    
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/videoJuegosPorDistribuidor", "/buscar", "/css/**", "/img/**")
                .permitAll()
                .antMatchers("/videojuegos/crear").hasAnyRole("ADMIN")
                .antMatchers("/distribuidor/crearDist").hasAnyRole("ADMIN")
                .antMatchers("/videojuegos/guardar").hasAnyRole("ADMIN")
                .antMatchers("/distribuidor/guardar").hasAnyRole("ADMIN")
                .antMatchers("/videojuegos/crear/**").hasAnyRole("ADMIN")
                .antMatchers("/videojuegos/eliminar/**").hasAnyRole("ADMIN")
                .antMatchers("/videojuegos/editar/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

}
