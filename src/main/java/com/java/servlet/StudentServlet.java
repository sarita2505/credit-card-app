package com.java.servlet;

import com.java.context.AppContext;
import com.java.model.Student;
import com.java.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class StudentServlet extends HttpServlet {


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPut(req, resp);
        Object data = null;
        String idStr = req.getParameter("id");
        // search by id
        if (idStr != null) {
            Integer id = Integer.parseInt(idStr);
            for (Student s : AppContext.STUDENT_LIST) {
                if (id.equals(s.getId())) {
                    data = s;
                    break;
                }
            }
            // when no matching id found on above iteration
            if (data == null) {
                data = -1;
            } else {
                //     AppContext.STUDENT_LIST.remove(data);
                Student inputData = AppUtils.getObjectFromRequest(req, Student.class);
                Student existingData = (Student) data;
                existingData.setCity(inputData.getCity());
                data = 0;
            }

            AppUtils.writeResponseAsJson(resp, 200, data);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   super.doDelete(req, resp);
        Object data = null;
        String idStr = req.getParameter("id");
        // search by id
        if (idStr != null) {
            Integer id = Integer.parseInt(idStr);
            for (Student s : AppContext.STUDENT_LIST) {
                if (id.equals(s.getId())) {
                    data = s;
                    break;
                }
            }
            // when no matching id found on above iteration
            if (data == null) {
                data = -1;
            } else {
                AppContext.STUDENT_LIST.remove(data);
                data = 0;
            }

            AppUtils.writeResponseAsJson(resp, 200, data);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Student s = AppUtils.getObjectFromRequest(req, Student.class);
        AppContext.STUDENT_LIST.add(s);
        int size = AppContext.STUDENT_LIST.size();
        AppUtils.writeResponseAsJson(resp, 201, size);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        Object data = null;
        String idStr = req.getParameter("id");
        // search by id
        if (idStr != null) {
            Integer id = Integer.parseInt(idStr);
            for (Student s : AppContext.STUDENT_LIST) {
                if (id.equals(s.getId())) {
                    data = s;
                    break;
                }
            }
            // when no matching id found on above iteration
            if (data == null) {
                data = Collections.EMPTY_LIST;
            }
        } else {
            data = AppContext.STUDENT_LIST;
        }

        AppUtils.writeResponseAsJson(resp, 200, data);
    }
}

