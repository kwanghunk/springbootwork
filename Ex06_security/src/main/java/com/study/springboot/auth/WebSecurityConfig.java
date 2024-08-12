package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {

	/*
	 * @Bean@Bean : 															아래 메소드를 Bean의 형태로 관리하겠다는 어노테이션 public SecurityFilterChain
	 * filterChain(HttpSecurity http) throws Exception { 
	 * 		http.csrf((csrf) -> csrf.disable()) 
	 * 			.cors((cors) -> cors.disable())
	 * 			.authorizeHttpRequests(request -> request
	 * 			.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
	 * 			.requestMatchers("/").permitAll()								아무나 다 들어올 수 있게 허용
	 * 			.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()	css,js,img 아무나 볼 수 있게 
	 * 			.requestMatchers("/guest/**").permitAll()						guest는 아무나 들어오게
	 * 			.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
	 * 			.requestMatchers("/admin/**").hasRole("ADMIN")					admin만 들어오게 
	 * 			.anyRequest()모든요청에 대해서.authenticated()인증 필요
	 * 		); 
	 * 		http.formLogin((formLogin) -> formLogin.permitAll()로그인 페이지는 아무나 들어올수 있게); 
	 * 		http.logout((logout) -> logout.permitAll());
	 *  
	 * 	return http.build(); 
	 * 	}
	 */
	@Autowired //CustomFailureHandler의 error_msg를 담을 수 있게
	AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
			.cors((cors) -> cors.disable())
			.authorizeHttpRequests(request -> request
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/").permitAll()
					.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
					.requestMatchers("/guest/**").permitAll()
					.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
			);
		
		
		/* 기본 제공되는 login form
		http.formLogin((formLogin) -> formLogin.permitAll());
		http.logout((logout) -> logout.permitAll());
		*/
		http.formLogin((formLogin) -> formLogin
				.loginPage("/loginForm")				// controller에 넣은 맵핑값
				.loginProcessingUrl("/login_check")		// form에 action에 넣은 url
				//.failureUrl("/loginError")			// 실패시 이동할 url로 할 때
				//.failureUrl("/loginForm?error")		// 실패시 error값을 받을 때
				.failureHandler(authenticationFailureHandler)
														// 실패시 authenticationFailureHandler가 될 수 있도록
				.usernameParameter("username")			// form에 넣은 ID_input의 name값 / 파라미터 디폴트(j_username)
				.passwordParameter("pwd")				// form에 넣은 PW_input의 name값 / 파라미터 디폴트(j_password)
				.permitAll());
		
		
		http.logout((logout) -> logout.permitAll());
		
		return http.build();
		
	}

	// user 정보를 db에 넣진않고 메모리에 저장
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("USER", "ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);/* 메모리에 담는 api */
	}

	/* 비밀번호 암호화, 기존에 이미 만들어져 있음 */
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
