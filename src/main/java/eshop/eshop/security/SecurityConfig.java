package eshop.eshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import eshop.eshop.filter.CustomAuthenticationFilter;
import eshop.eshop.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/auth/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /*
            ROUTES FOR: Permit all requests to the following paths REGIEST, LOGIN, LOGOUT, FORGOT, RESET
        */
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/auth/**", "/api/v1/token/refresh/**", "/api/v1/category/**", "/api/v1/product/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/auth/**", "/api/v1/category/**", "/api/v1/product/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/v1/auth/**", "/api/v1/category/**", "/api/v1/product/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/v1/auth/**", "/api/v1/category/**", "/api/v1/product/**").permitAll();
        
        /*
            ROUTES FOR: Permit all requests to the following paths
        */
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/users").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
