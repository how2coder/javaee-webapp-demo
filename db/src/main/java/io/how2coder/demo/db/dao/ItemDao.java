package io.how2coder.demo.db.dao;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao<T, Integer> {

    T get(Integer id) throws SQLException;

    List<T> getAll() throws SQLException;

    T save(T obj) throws SQLException;

    void update(T obj) throws SQLException;

    int delete(T obj) throws SQLException;
}
