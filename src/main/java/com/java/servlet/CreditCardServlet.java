package com.java.servlet;

import com.java.model.CreditCard;
import com.java.service.ICreditCardService;
import com.java.service.impl.CreditCardServiceImpl;
import com.java.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreditCardServlet extends HttpServlet {

    private ICreditCardService service=new CreditCardServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        CreditCard creditCard= AppUtils.getObjectFromRequest(req, CreditCard.class);
        Object responseData=service.insert(req,creditCard);
        AppUtils.writeResponseAsJson(resp,201,responseData);
    }
}
