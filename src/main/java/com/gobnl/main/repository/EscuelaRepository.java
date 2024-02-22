package com.gobnl.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gobnl.main.entity.Escuela;

@Repository
public interface EscuelaRepository extends MongoRepository<Escuela, String>{
	@Query("{'id':?0}")
	Escuela getEscuela(String id);
}
