package com.java.service;

import com.java.model.CreditCard;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public interface IServiceReprository  {

    /**
     * @param request HttpServletRrquest
     * @param creditCard data to insert
     * @return the number of rows inserted
     */
    int insert(HttpServletRequest request, CreditCard creditCard) ;

    /**
     * @param request HttpRequest
     * @param creditCard data to update
     * @return returns the number of rows inserted
     */
    int update(HttpServletRequest request,CreditCard creditCard);

    /**
     * @param request Httprequest
     * @param id of data which you want to delete
     * @return number of rows deleted
     */
    int delete(HttpServletRequest request,int id);

    /**
     * @param request HttpRequest
     * @return number of rows selected
     */
    int selectAll(HttpServletRequest request);

    /**
     * @param request HttpRequest
     * @param id of the data that you want to select
     * @return the selected data of the id
     */
    int selectById(HttpServletRequest request,int id);
}
