package com.java.repository.impl;

import com.java.model.CreditCard;
import com.java.repository.ICreditCardRepository;
import com.java.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CreditCardRepositoryImpl implements ICreditCardRepository {
    @Override
    public int insert(Connection con, CreditCard creditCard) throws SQLException {
        String query = "INSERT INTO CREDIT_CARD(ID,CARD_NAME,CVV,YEAR,MONTH,CARD_NUMBER,CARD_TYPE) VALUES(CREDIT_CARD_ID_SEQ.NEXTVAL,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query, new String[]{"ID"});
        ps.setString(1, creditCard.getCardName());
        ps.setInt(2,creditCard.getCvv());
        ps.setInt(3,creditCard.getYear());
        ps.setInt(4,creditCard.getMonth());
        ps.setLong(5, creditCard.getCardNumber());
        ps.setString(6,creditCard.getCardType());
        int recordId = 0;
        try {
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet != null && resultSet.next()) {
                    recordId = (int) resultSet.getLong(1);
                }
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            DatabaseConnectionManager.close(con);
        }

        return recordId;
    }

    @Override
    public int update(Connection con, CreditCard creditCard) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Connection con, int id) throws SQLException {
        return 0;
    }

    @Override
    public CreditCard selectById(Connection con, int id) throws SQLException {
        return null;
    }

    @Override
    public List<CreditCard> selectAll(Connection con) throws SQLException {
        return null;
    }
}
