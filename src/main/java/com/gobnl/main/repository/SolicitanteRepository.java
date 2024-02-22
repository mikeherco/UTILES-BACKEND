package com.gobnl.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gobnl.main.entity.Solicitante;

@Repository
public interface SolicitanteRepository extends MongoRepository<Solicitante, String> {
	@Query("{'curp':?0}")
	Solicitante getSolicitanteByCurp(String curp);
}