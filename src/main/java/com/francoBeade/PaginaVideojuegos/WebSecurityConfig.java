package com.francoBeade.PaginaVideojuegos;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/videoJuegosPorDistribuidor", "/buscar", "/css/**", "/img/**").permitAll()
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





	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passEncoder)
		.usersByUsernameQuery("Select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("Select u.username, r.rol from roles r inner join users u on r.user_id=u.id where u.username=?;");
		
	}
	
}
