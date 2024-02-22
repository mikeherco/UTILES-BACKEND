package com.gobnl.main.service;

import com.gobnl.main.entity.Funcionario;
import com.gobnl.main.entity.FuncionarioDetails;
import com.gobnl.main.exception.GobNLException;
import com.gobnl.main.jwt.JwtTokenProvider;
import com.gobnl.main.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl {
    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private JwtTokenProvider tokenProvider;

    public Funcionario getByUsername(String username) throws GobNLException {
        var funcionarios = repository.findByUsername(username);
        return funcionarios;
    }
    public String login(Funcionario funcionario, String password) throws GobNLException {
        return tokenProvider.generateToken(new FuncionarioDetails(funcionario));
    }
}