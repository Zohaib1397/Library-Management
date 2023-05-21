package Structures;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public T get(String username, String password) throws SQLException;

    public List<T> getAll() throws SQLException;

    public boolean insert(T t) throws SQLException;

    public boolean delete(T t);

    public boolean update(T t) throws SQLException;
}
