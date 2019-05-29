package com.example.money.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Autenticação Basic
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication() //Autenticação com usuário e senha em memória
			.withUser("admin").password("{noop}admin").roles("ROLE");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/categorias").permitAll() //Libera a rota para não utilizar autenticação
				.anyRequest().authenticated() //Qualquer requisição vai solicitar usuario e senha
				.and() 
			.httpBasic().and() //Tipo de autenticação
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() //Não mantem estado (Sem sessão)
			.csrf().disable(); 
	}
	
}