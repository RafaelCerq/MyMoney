package com.example.money.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication() //Autenticação com usuário e senha em memória
			.withUser("admin").password("{noop}admin").roles("ROLE");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/categorias").permitAll() //Libera a rota para não utilizar autenticação
				.anyRequest().authenticated() //Qualquer requisição vai solicitar usuario e senha
				.and() 
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() //Não mantem estado (Sem sessão)
			.csrf().disable(); 
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//		resources.stateless(true);
//	}
	
}