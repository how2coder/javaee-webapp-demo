package io.how2coder.demo.db.dao;

import io.how2coder.demo.model.Department;
import io.how2coder.demo.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao extends ItemDao<Employee, Long> {

    List<Employee> getAllEmployeesByDepartment(Department department) throws SQLException;
}
