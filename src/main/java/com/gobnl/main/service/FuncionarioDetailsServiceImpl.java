package com.gobnl.main.service;

import com.gobnl.main.entity.Funcionario;
import com.gobnl.main.entity.FuncionarioDetails;
import com.gobnl.main.exception.GobNLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    private static final Logger logger = LoggerFactory.getLogger(FuncionarioDetailsServiceImpl.class);

    public FuncionarioDetails loadUserByUsername(String username) {
        /* If user not in cache, call DB */
        Funcionario funcionario = null;
        try {
            funcionario = funcionarioService.getByUsername(username);
            return new FuncionarioDetails(funcionario);
        } catch (GobNLException e) {
            e.printStackTrace();
        }
        return null;
    }
}