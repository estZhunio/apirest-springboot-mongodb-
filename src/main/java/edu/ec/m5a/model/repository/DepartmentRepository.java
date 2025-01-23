package edu.ec.m5a.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.ec.m5a.model.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department, String>{

}
