package com.java.servlet;

import com.java.context.AppContext;
import com.java.model.Book;
import com.java.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

public class BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Book book = AppUtils.getObjectFromRequest(req, Book.class);
        AppUtils.writeResponseAsJson(resp, 201, book);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int x =0;
        while(x < 1)
        {
            x=0;
            System.out.println("running");
        }
        Object data = null;
        String idstr = req.getParameter("bookId");
        if (idstr != null) {
            Integer id = Integer.parseInt(idstr);
            for (Book b : AppContext.BOOK_LIST) {
                if (id.equals(b.getBookId())) {
                    data = b;
                    break;
                }
            }
            if (data == null) {
                data = Collections.EMPTY_LIST;
            }
        } else {
            data = AppContext.BOOK_LIST;
        }
        AppUtils.writeResponseAsJson(resp, 200, data);

    }
}
