package com.gobnl.main.jwt;

import com.gobnl.main.entity.FuncionarioDetails;
import com.gobnl.main.exception.GobNLException;
import com.gobnl.main.service.FuncionarioDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
    private JwtTokenProvider tokenProvider;
    private JwtConfig jwtConfig;
    private String serviceUsername;
    private FuncionarioDetailsServiceImpl funcionarioDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenAuthenticationFilter.class);

    public JwtTokenAuthenticationFilter(String serviceUsername, JwtConfig jwtConfig, JwtTokenProvider tokenProvider, FuncionarioDetailsServiceImpl funcionarioDetailsService) {
        this.tokenProvider = tokenProvider;
        this.jwtConfig = jwtConfig;
        this.serviceUsername = serviceUsername;
        this.funcionarioDetailsService = funcionarioDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. get the authentication header. Tokens are supposed to be passed in the authentication header
        String header = request.getHeader(jwtConfig.getHeader());
        // 2. validate the header and check the prefix
        if(header == null || !header.startsWith(jwtConfig.getPrefix())) {
            filterChain.doFilter(request, response);  		// If not valid, go to the next filter.
            return;
        }
        // 3. Get the token
        String token = header.replace(jwtConfig.getPrefix(), "");
        Claims claims;
        try {
            if((claims = tokenProvider.extractAllClaims(token)) != null) {
                String username = claims.getSubject();
                UsernamePasswordAuthenticationToken auth = null;

                if(username.equals(serviceUsername)) { // If it is service account don't load user details

                    List<String> authorities = (List<String>) claims.get("authorities");

                    auth = new UsernamePasswordAuthenticationToken(username, null,
                            authorities
                                    .stream()
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(toList()));
                } else {
                    FuncionarioDetails accountUserDetails = funcionarioDetailsService.loadUserByUsername(username);
                    auth = new UsernamePasswordAuthenticationToken(accountUserDetails, null, accountUserDetails.getAuthorities());
                }
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (GobNLException e) {
            e.printStackTrace();
        }
        /* Handling the control to the next filter chain */
        filterChain.doFilter(request, response);
    }
}
