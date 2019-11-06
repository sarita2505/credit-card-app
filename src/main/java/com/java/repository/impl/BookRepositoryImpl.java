package com.java.repository.impl;

import com.java.model.Book;
import com.java.repository.BookRowMapper;
import com.java.repository.IBookRepository;
import com.java.repository.IRowMapper;
import com.java.utils.DatabaseConnection;
import com.java.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    @Override
    public int insert(Connection con, Book book) throws SQLException {
        String query="INSERT INTO BOOK1(ID,BOOK_NAME,AUTHOR_NAME,PUBLICATION_NAME,EDITION) VALUES (BOOK1_ID_SEQ.NEXTVAL,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query,new String[]{"ID"});
        ps.setString(1,book.getBookName());
        ps.setString(2,book.getAuthorName());
        ps.setString(3,book.getPublicationNmae());
        ps.setInt(4,book.getEdition());
        int rowId=0;
        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                rowId = (int) resultSet.getLong(1);
            }
        }
        return rowId;
    }

    @Override
    public int update(Connection con, Book book) throws SQLException {
        String query="UPDATE BOOK1 SET BOOK_NAME=? WHERE ID=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,book.getBookName());
        ps.setInt(2,book.getBookId());
        int recordUpdated=ps.executeUpdate();
        return recordUpdated;
    }

    @Override
    public int delete(Connection con, int id) throws SQLException {
        String query="delete book1 where id=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,id);
        int rowsDeleted=ps.executeUpdate();
        return rowsDeleted;
    }

    @Override
    public Book selectById(Connection con, int id) throws SQLException {
        String query="select * from book1 where id=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet resultSet=ps.executeQuery();
        IRowMapper<Book>bookIRowMapper=new BookRowMapper();
       List<Book> bookList=bookIRowMapper.mapRow(resultSet);
       return  bookList.size() > 0 ? bookList.get(0):null;
    }

    @Override
    public List<Book> selectAll(Connection con) throws SQLException {
        return null;
    }
}
