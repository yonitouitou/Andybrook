package com.andybrook.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
                .and()
                .withUser("yoni").password(passwordEncoder().encode("yoni")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .authenticationEntryPoint(getAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                    .antMatchers("/index.html", "/", "/home", "/*.js", "/assets/**", "/actuator/**")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                    .authenticationEntryPoint(getAuthenticationEntryPoint())
                .and()
                .csrf()
                    .disable();//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                http
                .sessionManagement()
                    .maximumSessions(1)
                    .sessionRegistry(sessionRegistry());
    }

    private AuthenticationEntryPoint getAuthenticationEntryPoint() {
        return (request, response, e) -> {
            if (e != null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        };
    }
}