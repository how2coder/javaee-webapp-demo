package io.how2coder.demo.services;

import io.how2coder.demo.db.dao.EmployeeDao;
import io.how2coder.demo.db.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

    private static volatile EmployeeService instance;
    private final EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

    private EmployeeServiceImpl() {
    }

    public static EmployeeService getInstance() {
        if (instance == null) {
            synchronized (EmployeeService.class) {
                if (instance == null) {
                    instance = new EmployeeServiceImpl();
                }
            }
        }
        return instance;
    }

}
