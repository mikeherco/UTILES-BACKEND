package com.gobnl.main.controller;

import com.gobnl.main.dto.LoginDTO;
import com.gobnl.main.entity.Funcionario;
import com.gobnl.main.exception.GobNLException;
import com.gobnl.main.service.CypherService;
import com.gobnl.main.service.FuncionarioServiceImpl;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/gobnl/login")
@Validated
public class SolLoginAPI {
    @Autowired
    private FuncionarioServiceImpl funcionarioService;
    @Autowired
    private CypherService cypherService;
    @PostMapping(value = "")
    public ResponseEntity<String> login(@NotNull @RequestBody LoginDTO request) throws GobNLException {
        Funcionario funcionario = funcionarioService.getByUsername(request.getUsername());
        doesPasswordMatches(funcionario.getPassword(), request.getPassword());
        String jwt = funcionarioService.login(funcionario, request.getPassword());
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
    private void doesPasswordMatches(String pass, String dbPass) throws GobNLException {
        if(Boolean.TRUE.equals(
                cypherService.validatePassword(
                        pass, dbPass))) {
            throw new GobNLException("INCORRECT_PASSWORD");
        }
    }
}