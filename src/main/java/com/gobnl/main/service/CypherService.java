package com.gobnl.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CypherService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(CypherService.class);

    public CypherService() { }

    public String encodePassword(String pass) {
        return this.passwordEncoder.encode(pass);
    }
    public Boolean validatePassword(String pass, String dbPass) {
        return this.passwordEncoder.matches(pass, dbPass);
    }
}