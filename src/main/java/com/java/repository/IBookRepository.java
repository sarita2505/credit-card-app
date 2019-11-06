package com.java.repository;

import com.java.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IBookRepository {
    /*
     * @param con needs a database connection
     * @param book data to store
     * @return number of rows inserted
     * @throws SQLException
     */
    int insert(Connection con, Book book)throws SQLException;

    /**
     * @param con needs a database connection
     * @param book data to store
     * @return number of rows inserted
     * @throws SQLException
     */
    int update (Connection con,Book book)throws SQLException;

    /**
     *
     * @param con needs a database connection
     * @param id required to delete the record
     * @return number of rows deleted
     * @throws SQLException
     */
    int delete(Connection con,int id) throws SQLException;

    /**
     * @param con needs a database connection
     * @param id required to delete the record
     * @return number of rows deleted
     * @throws SQLException
     */
    Book selectById(Connection con,int id) throws SQLException;

    /**
     * @param con needs a database connection
     * @return number of rows selected
     * @throws SQLException
     */
    List<Book> selectAll(Connection con) throws SQLException;

}
