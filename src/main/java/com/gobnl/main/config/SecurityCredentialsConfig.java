package com.gobnl.main.config;

import com.gobnl.main.jwt.JwtConfig;
import com.gobnl.main.jwt.JwtTokenAuthenticationFilter;
import com.gobnl.main.jwt.JwtTokenProvider;
import com.gobnl.main.service.FuncionarioDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = false)
@Configuration
public class SecurityCredentialsConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private FuncionarioDetailsServiceImpl funcionarioDetailsService;
    @Value("${security.service.username}")
    private String serviceUsername;
    @Value("${security.service.username}")
    private String servicePassword;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(funcionarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(
                        (req, res, e) -> {
                            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                        })
                .and()
                .addFilterBefore(
                        new JwtTokenAuthenticationFilter(
                                serviceUsername,
                                jwtConfig,
                                tokenProvider,
                                funcionarioDetailsService
                        ),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/gobnl/login", "/gobnl/**").permitAll()
                .requestMatchers(HttpMethod.GET,  "/gobnl/**").permitAll()
                .requestMatchers(HttpMethod.DELETE,  "/gobnl/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/gobnl/estudiante").authenticated()
                .anyRequest().authenticated()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
        return http.build();
    }
}