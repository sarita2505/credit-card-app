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

public class CreditCardServiceImpl implements ICreditCardService {

    private ICreditCardRepository iCreditCardRepository = new CreditCardRepositoryImpl();

    @Override
    public int insert(HttpServletRequest request, CreditCard creditCard) {
        Connection connection = DatabaseConnectionManager.getConnection();
        int recordId = 0;
        try {
            recordId = iCreditCardRepository.insert(connection, creditCard);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
        return recordId;
    }

    @Override
    public int update(HttpServletRequest request, CreditCard creditCard) {
        return 0;
    }

    @Override
    public int delete(HttpServletRequest request, int id) {
        return 0;
    }

    @Override
    public int selectAll(HttpServletRequest request) {
        return 0;
    }

    @Override
    public int selectById(HttpServletRequest request, int id) {
        return 0;
    }
}
