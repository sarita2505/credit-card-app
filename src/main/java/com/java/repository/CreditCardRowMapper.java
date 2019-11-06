package com.java.repository;

import com.java.model.CreditCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditCardRowMapper implements IRowMapper<CreditCard> {
    @Override
    public List<CreditCard> mapRow(ResultSet rs) throws SQLException {
        //return null;
        List<CreditCard> list=new ArrayList<>();
       while (rs.next()){
           int id=(int)rs.getLong("id");
           String cardName=rs.getString("card_name");
           CreditCard creditCard=new CreditCard();
           creditCard.setId(id);
           creditCard.setCardName(cardName);

           list.add(creditCard);
       }
        return list;
    }
}
