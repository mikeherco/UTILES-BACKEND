package com.gobnl.main.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "funcionarios")
public class Funcionario {
    @Id
    private String funcionarioId;
    private String username;
    private String password;
    @DBRef
    private Set<Roles> roles;

    public Funcionario() {}
    public Funcionario(Funcionario funcionario) {
        this.funcionarioId = funcionario.getFuncionarioId();
        this.username = funcionario.getUsername();
        this.password = funcionario.getPassword();
        this.roles = funcionario.getRoles();
        //no me gusta tu teclado
    }
    public Funcionario(String funcionarioId, String username, String password, Set<Roles> roles) {
        this.funcionarioId = funcionarioId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    public Funcionario( String username, String password, Set<Roles> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    public String getFuncionarioId() {
        return funcionarioId;
    }
    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Roles> getRoles() {
        return roles;
    }
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "funcionarioId='" + funcionarioId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}