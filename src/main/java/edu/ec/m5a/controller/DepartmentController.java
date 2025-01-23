package edu.ec.m5a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.ec.m5a.model.entity.Department;
import edu.ec.m5a.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartments(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable String id, @RequestBody Department departmentDetails) {
        return departmentService.updateDepartment(id, departmentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }
}