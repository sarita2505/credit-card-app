package com.java.repository;

import com.java.model.Book;
import com.java.repository.impl.BookRepositoryImpl;
import com.java.utils.DatabaseConnectionManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class BookRepositoryImplTest {


    @Test
    public void testData() {
        Book book = new Book();
        //book.setBookName("python");
        //book.setBookId(23);
        //book.setAuthorName("balguruSwami");

       // book.setPublicationNmae("kalyani");
        //book.setEdition(2018);

        Connection connection = DatabaseConnectionManager.getConnection();
        IBookRepository iBookRepository = new BookRepositoryImpl();
        int rowId = 0;
        try {
            //rowId = iBookRepository.insert(connection, book);
            //rowId = iBookRepository.update(connection, book);
            //rowId = iBookRepository.delete(connection,23);
           // rowId = iBookRepository.selectById(connection,45);
            Book book1=iBookRepository.selectById(connection,45);
            connection.commit();
        } catch (SQLException e) {
            DatabaseConnectionManager.rollbackTransaction(connection);
            throw new RuntimeException(e);
        } finally {
            DatabaseConnectionManager.close(connection);
        }

        Assert.assertNotEquals(rowId, 0);
    }
}
