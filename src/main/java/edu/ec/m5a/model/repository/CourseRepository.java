package edu.ec.m5a.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.ec.m5a.model.entity.Course;

public interface CourseRepository extends MongoRepository<Course, String>{

}
