package com.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IRowMapper<T> {
    List<T> mapRow(ResultSet rs) throws SQLException;
}
