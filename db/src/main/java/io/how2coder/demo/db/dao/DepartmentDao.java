package io.how2coder.demo.db.dao;

import io.how2coder.demo.model.Department;

import java.sql.SQLException;
import java.util.List;

public class DepartmentDao implements ItemDao<Department, Integer> {

    @Override
    public Department get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Department> getAll() throws SQLException {
        return null;
    }

    @Override
    public Department save(Department obj) throws SQLException {
        return null;
    }

    @Override
    public void update(Department obj) throws SQLException {

    }

    @Override
    public int delete(Department obj) throws SQLException {
        return 0;
    }
}
