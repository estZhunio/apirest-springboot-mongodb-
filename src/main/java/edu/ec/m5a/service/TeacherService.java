package edu.ec.m5a.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ec.m5a.model.entity.Teacher;
import edu.ec.m5a.model.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> getTeacherById(String id) {
        return teacherRepository.findById(id);
    }

    public Teacher updateTeacher(String id, Teacher teacherDetails) {
        return teacherRepository.findById(id).map(teacher -> {
            teacher.setNombre(teacherDetails.getNombre());
            teacher.setDireccion(teacherDetails.getDireccion());
            teacher.setTelefono(teacherDetails.getTelefono());
            return teacherRepository.save(teacher);
        }).orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));
    }

    public void deleteTeacher(String id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        } else {
            throw new RuntimeException("Profesor no encontrado con ID: " + id);
        }
    }
}