package io.how2coder.demo.db.dao;

import io.how2coder.demo.model.Manager;

import java.sql.SQLException;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {

    private static volatile ManagerDao instance;

    private ManagerDaoImpl() {
    }

    public static ManagerDao getInstance() {
        if (instance == null) {
            synchronized (ManagerDao.class) {
                if (instance == null) {
                    instance = new ManagerDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Manager get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Manager> getAll() throws SQLException {
        return null;
    }

    @Override
    public Manager save(Manager obj) throws SQLException {
        return null;
    }

    @Override
    public void update(Manager obj) throws SQLException {

    }

    @Override
    public int delete(Manager obj) throws SQLException {
        return 0;
    }
}
