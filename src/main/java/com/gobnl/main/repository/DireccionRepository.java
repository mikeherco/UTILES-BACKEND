package com.gobnl.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.gobnl.main.entity.Direccion;

@Repository
public interface DireccionRepository extends MongoRepository<Direccion, String> {
	@Query("{'curp':?0}")
	Direccion getDireccionByCurp(String curp);
}
