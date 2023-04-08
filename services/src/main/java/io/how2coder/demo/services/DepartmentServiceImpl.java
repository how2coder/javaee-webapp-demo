package io.how2coder.demo.services;

import io.how2coder.demo.db.dao.DepartmentDao;
import io.how2coder.demo.db.dao.DepartmentDaoImpl;
import io.how2coder.demo.db.dao.EmployeeDao;
import io.how2coder.demo.db.dao.EmployeeDaoImpl;
import io.how2coder.demo.model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentServiceImpl.class);

    private static volatile DepartmentService instance;
    private final DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();
    private final EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

    private DepartmentServiceImpl() {
    }

    public static DepartmentService getInstance() {
        if (instance == null) {
            synchronized (DepartmentService.class) {
                if (instance == null) {
                    instance = new DepartmentServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Optional<List<Department>> getAllDepartments() {
        try {
            List<Department> departments = departmentDao.getAll();
            return Optional.of(departments);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return getDepartmentById(id, false);
    }

    @Override
    public Optional<Department> getDepartmentById(Long id, boolean includeRelations) {
        try {
            Department department = departmentDao.get(id);
            employeeDao.getAllEmployeesByDepartment(department);
            return Optional.ofNullable(department);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return Optional.empty();
    }
}
