package com.java.repository;

import com.java.model.CreditCard;
import com.java.repository.impl.CreditCardRepositoryImpl;
import com.java.utils.DatabaseConnectionManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class CreditCardRepositoryImplTest {

    @Test
    public void insertTest() throws SQLException {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardName("platinum");
        creditCard.setCvv(050);
        creditCard.setMonth(11);
        creditCard.setYear(2023);
        creditCard.setCardNumber(1098909876856575l);
        creditCard.setCardType("VISA");
        Connection con = DatabaseConnectionManager.getConnection();
        ICreditCardRepository iCreditCardRepository = new CreditCardRepositoryImpl();
        int recordId = iCreditCardRepository.insert(con, creditCard);
        Assert.assertNotEquals(recordId, 0);
    }
}