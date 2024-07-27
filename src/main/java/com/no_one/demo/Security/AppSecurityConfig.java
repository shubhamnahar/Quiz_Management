package com.no_one.demo.Security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider() {
//    	System.out.println("Heree.........");
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
//        System.out.println("--------------providerrr------:"+provider);
        return provider;
    }
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable() // Disable CSRF for simplicity, enable in production
            .authorizeRequests()
            .requestMatchers("/question/add").hasRole("ADMIN") // Only ADMIN can access
            .requestMatchers("/quiz/create").hasRole("ADMIN")
            .requestMatchers("/users/createUser").hasRole("ADMIN")
            .requestMatchers("/quiz/sumbit/*").hasRole("ADMIN")  //.requestMatchers("/question/view").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));//3000
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//	        .csrf()
//	        .disable()          
//	        .authorizeHttpRequests()
//	        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // Permit access to public resources
//	        .requestMatchers("/login", "/logout", "/home").permitAll() // Permit access to login, logout, and home pages
//	        .anyRequest()
//	        .authenticated()
//	        .and()
//	        .formLogin()
//	        .loginPage("/login.jsp").permitAll()
//	        .and()
//	        .logout().invalidateHttpSession(true)
//	        .clearAuthentication(true)
//	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	        .logoutSuccessUrl("/home").permitAll();
//        return http.build();
//    }
        
    
    
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                	.requestMatchers("/static/**").permitAll() // Permit access to public resources
//                    .anyRequest().authenticated()
//            )
//            .formLogin(formLogin ->
//                {
//					try {
//						formLogin
////						    .loginPage("/awesome.html")
//							.loginPage("/login.jsp")	
//						    .permitAll()
//						    .and()
//						    .logout().invalidateHttpSession(true)
//						    .clearAuthentication(true);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//                    
//            );
        
    
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .antMatchers("/static/**").permitAll() // Permit access to static resources
//                    .anyRequest().authenticated()
//            )
//            .formLogin(formLogin ->
//                formLogin
//                    .loginPage("/login.jsp")
//                    .permitAll()
//            )
//            .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true);
//    }
//}
    
    
    
}
