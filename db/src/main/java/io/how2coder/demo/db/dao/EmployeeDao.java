package io.how2coder.demo.db.dao;

import io.how2coder.demo.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDao implements ItemDao<Employee, Integer> {

    @Override
    public Employee get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return null;
    }

    @Override
    public Employee save(Employee obj) throws SQLException {
        return null;
    }

    @Override
    public void update(Employee obj) throws SQLException {

    }

    @Override
    public int delete(Employee obj) throws SQLException {
        return 0;
    }
}
