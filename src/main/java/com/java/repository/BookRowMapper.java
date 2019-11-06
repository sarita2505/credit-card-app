package com.java.repository;

import com.java.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRowMapper implements IRowMapper<Book> {
    @Override
    public List<Book> mapRow(ResultSet rs) throws SQLException {
        List<Book> bookList=new ArrayList<>();

        while (rs.next()){
           int id= rs.getInt("id");
           String bookName= rs.getString("book_name");
            Book book=new Book();
            book.setBookId(id);
            book.setBookName(bookName);
            bookList.add(book);
        }
        return bookList;
    }
}
