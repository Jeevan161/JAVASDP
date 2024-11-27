package com.klef.jfsd.sdp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@SuppressWarnings("unused")
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig extends SavedRequestAwareAuthenticationSuccessHandler  {
    
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 boolean[] isOTPVerified2= {false};
		 boolean[] isAdminVerified2 = {false};		 
		 http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        	.requestMatchers(new AntPathRequestMatcher("/seller/**")).hasAnyAuthority("USER")	
            .requestMatchers(new AntPathRequestMatcher("/admin/**")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
        )
                .exceptionHandling(exceptions -> exceptions.accessDeniedPage("/Basic/Error.jsp"))
                .formLogin()
                .loginPage("/login")
                .permitAll();
        
        http.formLogin()
        .successHandler((request, response, authentication) -> {
            boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
            boolean isUser = authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("USER"));
            boolean isOTPVerified = ((MemberInfoDetails) authentication.getPrincipal()).isOTPVerified();
            boolean isAdminVerified = ((MemberInfoDetails) authentication.getPrincipal()).isAdminVerified();
            isOTPVerified2[0] =isOTPVerified;
            isAdminVerified2[0] =isAdminVerified;
            
            System.out.println(isAdminVerified);

            if (isAdmin) {
                response.sendRedirect("/admin/home");
            } else if (isUser && isOTPVerified && isAdminVerified) {
                response.sendRedirect("/seller/home");
            } else if (isUser && !isOTPVerified) {
                response.sendRedirect("/seller/otpverify");
            } else if(!isAdminVerified){
            	 response.sendRedirect("/seller/adminVerficationPending");
            }
            else {
                response.sendRedirect("/dashboard"); // Default for other roles
            }
        });
        
        if(isAdminVerified2[0] && isOTPVerified2[0])
        {
        	
        }
        
	    return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService()
	{
		return new MemberInfoUserDetailsService();
	}
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
