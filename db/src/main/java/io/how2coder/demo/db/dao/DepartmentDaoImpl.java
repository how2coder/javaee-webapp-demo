package io.how2coder.demo.db.dao;

import io.how2coder.demo.db.connection.ConnectionManager;
import io.how2coder.demo.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static final String SELECT_ALL = "SELECT id, name FROM department";
    private static final String SELECT_BY_ID = "SELECT id, name FROM department WHERE id = ?";

    private static volatile DepartmentDao instance;

    private DepartmentDaoImpl() {
    }

    public static DepartmentDao getInstance() {
        if (instance == null) {
            synchronized (DepartmentDao.class) {
                if (instance == null) {
                    instance = new DepartmentDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Department get(Long id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getLong("id"));
                    department.setName(resultSet.getString("name"));
                    return department;
                }
            }
        }
        throw new SQLException("Department not found");
    }

    @Override
    public List<Department> getAll() throws SQLException {
        List<Department> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                result.add(department);
            }
        }
        return result;
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
