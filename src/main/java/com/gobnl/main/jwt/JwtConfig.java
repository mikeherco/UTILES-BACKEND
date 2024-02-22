package com.gobnl.main.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class JwtConfig {
    @Value("${security.jwt.uri:/auth/**}")
    private String jwtUri;
    @Value("${security.jwt.header:Authorization}")
    private String header;
    @Value("${security.jwt.prefix:Bearer}")
    private String prefix;
    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;
    @Value("${security.jwt.secret:JwtSecretKey}")
    private String secret;

    public JwtConfig() { }
    public JwtConfig(String jwtUri, String prefix, String header, int expiration, String secret) {
        this.jwtUri = jwtUri;
        this.prefix = prefix;
        this.header = header;
        this.expiration = expiration;
        this.secret = secret;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getJwtUri() {
        return jwtUri;
    }
    public void setJwtUri(String jwtUri) {
        this.jwtUri = jwtUri;
    }
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public int getExpiration() {
        return expiration;
    }
    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }
    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
}