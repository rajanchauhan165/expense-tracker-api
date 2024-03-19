package com.rajan.eta.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.rajan.eta.Security.MyUserDetailsService;


@Configuration
public class WebSecurityConfig{
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
		return httpSecurity
				.csrf(httpcsrf -> httpcsrf.disable())
				.authorizeHttpRequests(autz->{
			autz.requestMatchers("/login","/register").permitAll();
			autz.anyRequest().authenticated();
		})
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults())
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return myUserDetailsService;
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authz = new DaoAuthenticationProvider();
		authz.setUserDetailsService(myUserDetailsService);
		authz.setPasswordEncoder(passwordEncoder());
		return authz;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
