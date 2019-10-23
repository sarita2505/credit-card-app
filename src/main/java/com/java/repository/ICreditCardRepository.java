package com.java.repository;

import com.java.model.CreditCard;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ICreditCardRepository {

    /**
     * @param con database connection
     * @param creditCard data to persist
     * @return number of rows inserted
     * @throws SQLException
     */
    int insert(Connection con, CreditCard creditCard) throws SQLException;

    /**
     * @param con database connection
     * @param creditCard data to update
     * @return number of rows updated
     * @throws SQLException
     */
    int update(Connection con, CreditCard creditCard) throws SQLException;

    /**
     * @param con database connection
     * @param id id of the creditcard to delete
     * @return number of rows deleted
     * @throws SQLException
     */
    int delete(Connection con, int id) throws SQLException;

    /**
     * @param con database connection
     * @param id id of the creditcard to select
     * @return null if no creditcard found else returns the credit card
     * @throws SQLException
     */
    CreditCard selectById(Connection con,int id)throws SQLException;

    /**
     * @param con database connection
     * @return list of credit cards
     * @throws SQLException
     */
    List<CreditCard> selectAll(Connection con)throws SQLException;
}
