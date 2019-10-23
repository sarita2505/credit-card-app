package com.java.servlet;

import com.java.context.AppContext;
import com.java.model.Employee;
import com.java.model.Student;
import com.java.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Employee s=AppUtils.getObjectFromRequest(req,Employee.class);
        AppContext.EMPLOYEE_LIST.add(s);
        int size=AppContext.EMPLOYEE_LIST.size();
        AppUtils.writeResponseAsJson(resp,201,size);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        Object data = null;
        String idStr = req.getParameter("id");
        if (idStr != null) {
            Integer id = Integer.parseInt(idStr);
            for (Employee e : AppContext.EMPLOYEE_LIST) {
                if (id.equals(e.getId())) {
                    data = e;
                    break;
                }
            }
            if (data == null) {
                data = Collections.EMPTY_LIST;
            }
        } else {
            data = AppContext.EMPLOYEE_LIST;
        }

        AppUtils.writeResponseAsJson(resp, 200, data);
    }
}
