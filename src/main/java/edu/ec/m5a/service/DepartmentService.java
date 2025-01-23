package edu.ec.m5a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ec.m5a.model.entity.Department;
import edu.ec.m5a.model.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartments(Department department) {
        return departmentRepository.save(department);
    }
    
    public Optional<Department> getDepartmentById(String id) {
        return departmentRepository.findById(id);
    }
    
    public void deleteDepartment(String id) {
        if (departmentRepository.existsById(id)) {
        	departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Departamento no encontrado con ID: " + id);
        }
    }
    
    public Department updateDepartment(String id, Department departmentDetails) {
        return departmentRepository.findById(id).map(department -> {
            department.setNombre(departmentDetails.getNombre());
            department.setDirector(departmentDetails.getDirector());
            department.setDescripcion(departmentDetails.getDescripcion());
            return departmentRepository.save(department);
        }).orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
    }
}
