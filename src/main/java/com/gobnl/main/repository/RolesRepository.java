package com.gobnl.main.repository;

import com.gobnl.main.entity.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends MongoRepository<Roles, String> {
}