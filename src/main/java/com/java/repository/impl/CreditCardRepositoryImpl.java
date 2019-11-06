package com.java.repository.impl;

import com.java.model.CreditCard;
import com.java.repository.CreditCardRowMapper;
import com.java.repository.ICreditCardRepository;
import com.java.repository.IRowMapper;
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
        ps.setInt(2, creditCard.getCvv());
        ps.setInt(3, creditCard.getYear());
        ps.setInt(4, creditCard.getMonth());
        ps.setLong(5, creditCard.getCardNumber());
        ps.setString(6, creditCard.getCardType());
        int recordId = 0;
         int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                recordId = (int) resultSet.getLong(1);
            }
        }
        return recordId;
    }

    @Override
    public int update(Connection con, CreditCard creditCard) throws SQLException {
        String query = "update  credit_card set card_name=? where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, creditCard.getCardName());
        ps.setLong(2, creditCard.getId());
        int rowsUpdated = ps.executeUpdate();
        return rowsUpdated;
    }

    @Override
    public int delete(Connection con, int id) throws SQLException {
        String query = "delete from  credit_card  where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, id);
        int rowsDeleted = ps.executeUpdate();
        return rowsDeleted;
    }

    @Override
    public CreditCard selectById(Connection con, int id) throws SQLException {
        String query = "select * from credit_card where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        IRowMapper<CreditCard> rowMapper = new CreditCardRowMapper();
        List<CreditCard> list = rowMapper.mapRow(rs);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<CreditCard> selectAll(Connection con) throws SQLException {
        String query = "select * from credit_card";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        IRowMapper<CreditCard> rowMapper = new CreditCardRowMapper();
        List<CreditCard> list = rowMapper.mapRow(rs);
        return list;
    }
}
