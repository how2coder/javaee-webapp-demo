package io.how2coder.demo.services;

import io.how2coder.demo.db.dao.DepartmentDao;
import io.how2coder.demo.db.dao.DepartmentDaoImpl;
import io.how2coder.demo.model.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {

    private static volatile DepartmentService instance;
    private final DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();

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
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
