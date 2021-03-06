package br.com.blog.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/artigos").hasRole("ADMIN")
		.antMatchers("/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll();
	}
	
	@Autowired
	private UserDetailsService user;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) 
			throws Exception{
		auth.userDetailsService(user);
	
	}
	

}
