package com.gobnl.main.repository;

import com.gobnl.main.entity.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    @Query("{'username':?0}")
    Funcionario findByUsername(String username);
}
