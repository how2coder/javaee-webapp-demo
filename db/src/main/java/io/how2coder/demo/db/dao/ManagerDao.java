package io.how2coder.demo.db.dao;

import io.how2coder.demo.model.Manager;

import java.sql.SQLException;
import java.util.List;

public class ManagerDao implements ItemDao<Manager,Integer> {

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
