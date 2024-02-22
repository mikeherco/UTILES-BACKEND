package com.gobnl.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.gobnl.main.entity.Estudiante;

@Repository
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
	@Query("{'curp':?0}")
	Estudiante getEstudianteByCurp(String id);
	@Query("{'solCurp':?0}")
	Estudiante getEstudianteBySolCurp(String id);
}
