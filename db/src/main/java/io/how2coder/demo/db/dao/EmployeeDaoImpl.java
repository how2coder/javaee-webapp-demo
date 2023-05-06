package io.how2coder.demo.db.dao;

import io.how2coder.demo.db.connection.ConnectionManager;
import io.how2coder.demo.model.Department;
import io.how2coder.demo.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String SELECT_ALL = "SELECT id, first_name, last_name, birth_date, salary, active FROM employee";
    private static final String SELECT_BY_ID = "SELECT id, first_name, last_name, birth_date, salary, active FROM employee WHERE id = ?";
    private static final String SELECT_ALL_BY_DEPARTMENT_ID = "SELECT id, first_name, last_name, birth_date, salary, active FROM employee WHERE department_id = ?";

    private static volatile EmployeeDao instance;

    private EmployeeDaoImpl() {
    }

    public static EmployeeDao getInstance() {
        if (instance == null) {
            synchronized (EmployeeDao.class) {
                if (instance == null) {
                    instance = new EmployeeDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Employee get(Long id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getLong(Employee.ID_COLUMN));
                    employee.setFirstName(resultSet.getString(Employee.FIRST_NAME_COLUMN));
                    employee.setLastName(resultSet.getString(Employee.LAST_NAME_COLUMN));
                    employee.setBirthDate(resultSet.getDate(Employee.BIRTHDATE_COLUMN).toLocalDate());
                    employee.setSalary(resultSet.getBigDecimal(Employee.SALARY_COLUMN));
                    employee.setActive(resultSet.getBoolean(Employee.ACTIVE_COLUMN));
                    return employee;
                }
            }
        }
        throw new SQLException("Department not found");
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong(Employee.ID_COLUMN));
                employee.setFirstName(resultSet.getString(Employee.FIRST_NAME_COLUMN));
                employee.setLastName(resultSet.getString(Employee.LAST_NAME_COLUMN));
                employee.setBirthDate(resultSet.getDate(Employee.BIRTHDATE_COLUMN).toLocalDate());
                employee.setSalary(resultSet.getBigDecimal(Employee.SALARY_COLUMN));
                employee.setActive(resultSet.getBoolean(Employee.ACTIVE_COLUMN));
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public void save(Employee obj) throws SQLException {

    }

    @Override
    public void update(Employee obj) throws SQLException {

    }

    @Override
    public int delete(Employee obj) throws SQLException {
        return 0;
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(Department department) throws SQLException {
        List<Employee> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_DEPARTMENT_ID)) {
            preparedStatement.setLong(1, department.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getLong(Employee.ID_COLUMN));
                    employee.setFirstName(resultSet.getString(Employee.FIRST_NAME_COLUMN));
                    employee.setLastName(resultSet.getString(Employee.LAST_NAME_COLUMN));
                    employee.setBirthDate(resultSet.getDate(Employee.BIRTHDATE_COLUMN).toLocalDate());
                    employee.setSalary(resultSet.getBigDecimal(Employee.SALARY_COLUMN));
                    employee.setActive(resultSet.getBoolean(Employee.ACTIVE_COLUMN));
                    result.add(employee);
                }
            }
        }
        department.setEmployees(result);
        return result;
    }
}
