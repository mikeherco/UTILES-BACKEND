package com.gobnl.main.jwt;

import com.gobnl.main.entity.FuncionarioDetails;
import com.gobnl.main.exception.GobNLException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider {
    @Autowired
    private JwtConfig jwtConfig;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    public JwtTokenProvider() {}
    public String generateToken(FuncionarioDetails funcionarioDetails) {
        Map<String, Object> claims = this.generateClaims(funcionarioDetails);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(funcionarioDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpiration()))
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret()).compact();
    }
    public Claims extractAllClaims(String jwt) throws GobNLException {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret())
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        } catch (Exception e) {
            throw new GobNLException("JWT_CLAIMS_EXC");
        }

        return null;
    }
    private Map<String, Object> generateClaims(FuncionarioDetails funcionarioDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", funcionarioDetails.getAuthorities());
        claims.put("username", funcionarioDetails.getUsername());
        return claims;
    }
}
