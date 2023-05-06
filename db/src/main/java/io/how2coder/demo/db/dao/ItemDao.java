package io.how2coder.demo.db.dao;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao<T, K> {

    T get(K id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save(T obj) throws SQLException;

    void update(T obj) throws SQLException;

    int delete(T obj) throws SQLException;
}
