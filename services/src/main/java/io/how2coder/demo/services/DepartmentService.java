package io.how2coder.demo.services;

import io.how2coder.demo.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Optional<List<Department>> getAllDepartments();

    Optional<Department> getDepartmentById(Long id);

    Optional<Department> getDepartmentById(Long id, boolean includeRelations);
}
