package com.java.service.impl;

import com.java.model.CreditCard;
import com.java.repository.ICreditCardRepository;
import com.java.repository.impl.CreditCardRepositoryImpl;
import com.java.service.ICreditCardService;
import com.java.utils.DatabaseConnection;
import com.java.utils.DatabaseConnectionManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CreditCardServiceImpl implements ICreditCardService {

    private ICreditCardRepository iCreditCardRepository = new CreditCardRepositoryImpl();

    @Override
    public int insert(HttpServletRequest request, CreditCard creditCard) {
        Connection connection = DatabaseConnectionManager.getConnection();
        int recordId = 0;
        try {
            recordId = iCreditCardRepository.insert(connection, creditCard);
            connection.commit();
        } catch (SQLException e) {
            // rollback here
            DatabaseConnectionManager.rollbackTransaction(connection);
            throw new RuntimeException(e);
        } finally {
            // close here
            DatabaseConnectionManager.close(connection);
        }
        return recordId;
    }

    @Override
    public int update(HttpServletRequest request, CreditCard creditCard) {
        String idStr = request.getParameter("id");
        int id = Integer.valueOf(idStr);
        creditCard.setId(id);//consider the id from url not from body
        Connection con = DatabaseConnectionManager.getConnection();
        int rowsUpdated = 0;
        try {
            rowsUpdated = iCreditCardRepository.update(con, creditCard);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionManager.rollbackTransaction(con);
            throw new RuntimeException(e);
        } finally {
            DatabaseConnectionManager.close(con);
        }
        return rowsUpdated;
    }

    @Override
    public int delete(HttpServletRequest request, int id) {
        Connection con = DatabaseConnectionManager.getConnection();
        int rowsDeleted = 0;
        try {
            rowsDeleted = iCreditCardRepository.delete(con, id);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseConnectionManager.rollbackTransaction(con);
            throw new RuntimeException(e);
        } finally {
            DatabaseConnectionManager.close(con);
        }
        return rowsDeleted;
    }

    @Override
    public List<CreditCard> selectAll(HttpServletRequest request) {
        Connection con = DatabaseConnectionManager.getConnection();
        try {
            return iCreditCardRepository.selectAll(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DatabaseConnectionManager.close(con);
        }
    }

    @Override
    public CreditCard selectById(HttpServletRequest request, int id) {
        Connection con = DatabaseConnectionManager.getConnection();
        try {
            return iCreditCardRepository.selectById(con, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DatabaseConnectionManager.close(con);
        }
    }
}
