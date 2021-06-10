package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dawes.servicioImpl.ServicioUsuariosImpl;

@Configuration
@EnableWebSecurity
public class MiSeguridad extends WebSecurityConfigurerAdapter{
	
	@Autowired
	ServicioUsuariosImpl su;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public String encripta(String password) {
		return passwordEncoder().encode(password);
	}
	// programa la autenticacion
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(su);
	}
	
	//programo la autorizacion
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/crearpublicacion").hasAnyRole("USER","ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/crearpublicacion").hasAnyRole("USER","ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/proveedor").hasAnyRole("USER","ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/proveedor").hasRole("ADMIN");
		http.httpBasic();
		http.formLogin().loginPage("/login");
		http.exceptionHandling().accessDeniedPage("/403");
		http.logout().logoutSuccessUrl("/index");
		http.csrf().disable();
	}
}
