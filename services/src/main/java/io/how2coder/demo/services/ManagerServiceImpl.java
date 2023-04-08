package io.how2coder.demo.services;

import io.how2coder.demo.db.dao.ManagerDao;
import io.how2coder.demo.db.dao.ManagerDaoImpl;

public class ManagerServiceImpl implements ManagerService {

    private static volatile ManagerService instance;
    private final ManagerDao managerDao = ManagerDaoImpl.getInstance();

    private ManagerServiceImpl() {
    }

    public static ManagerService getInstance() {
        if (instance == null) {
            synchronized (ManagerService.class) {
                if (instance == null) {
                    instance = new ManagerServiceImpl();
                }
            }
        }
        return instance;
    }
}
