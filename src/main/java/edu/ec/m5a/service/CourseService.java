package edu.ec.m5a.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ec.m5a.model.entity.Course;
import edu.ec.m5a.model.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository
    courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public Course updateCourse(String id, Course courseDetails) {
        return courseRepository.findById(id).map(course -> {
            course.setNombre(courseDetails.getNombre());
            course.setNivel(courseDetails.getNivel());
            course.setDescripcion(courseDetails.getDescripcion());
            return courseRepository.save(course);
        }).orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    public void deleteCourse(String id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Curso no encontrado con ID: " + id);
        }
    }
}