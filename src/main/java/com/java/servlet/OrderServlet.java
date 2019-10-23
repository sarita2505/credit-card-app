package com.java.servlet;

import com.java.context.AppContext;
import com.java.model.Order;
import com.java.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        Object data = null;
        String getRequestpara = req.getParameter("id");
        if (getRequestpara != null) {

            Integer id = Integer.parseInt(getRequestpara);
            for (Order o :
                    AppContext.ORDER_LIST) {

                if (id.equals(o.getOrderId())) {
                    data = o;
                    break;
                }
            }
            if (data == null) {

                data = Collections.EMPTY_LIST;
            }
        } else {
            data = AppContext.ORDER_LIST;
        }
        AppUtils.writeResponseAsJson(resp, 200, data);
    }
}

