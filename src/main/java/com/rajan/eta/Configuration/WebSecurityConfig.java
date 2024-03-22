package com.rajan.eta.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
				.formLogin(formlogin->formlogin.disable()).httpBasic(Customizer.withDefaults())
				.build();
	}


	
	@Bean
	UserDetailsService userDetailsService() {
		return myUserDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authz = new DaoAuthenticationProvider();
		authz.setUserDetailsService(myUserDetailsService);
		authz.setPasswordEncoder(passwordEncoder());
		return authz;
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
