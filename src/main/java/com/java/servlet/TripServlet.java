package com.java.servlet;

import com.java.context.AppContext;
import com.java.model.Student;
import com.java.model.Trip;
import com.java.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class TripServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        Object data = null;
        String strDestination = req.getParameter("destination");
        if (strDestination != null) {
            for (Trip t :
                    AppContext.TRIP_LIST) {
                if (strDestination.equals(t.getDestination())) {
                    data = t;
                    break;
                }
                if (data == null) {
                    data = Collections.EMPTY_LIST;
                }
            }
        } else {
            data = AppContext.TRIP_LIST;
        }

        AppUtils.writeResponseAsJson(resp, 200, data);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Trip t = AppUtils.getObjectFromRequest(req, Trip.class);
        AppContext.TRIP_LIST.add(t);
        int size = AppContext.TRIP_LIST.size();
        AppUtils.writeResponseAsJson(resp, 201, size);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doDelete(req, resp);
        Object data = null;
        String dest = req.getParameter("dest");
        // search by id
        if (dest != null) {

            for (Trip t : AppContext.TRIP_LIST) {
                if (dest.equals(t.getDestination())) {
                    data = t;
                    break;
                }
            }
            // when no matching id found on above iteration
            if (data == null) {
                data = -1;
            }
            else{
                AppContext.TRIP_LIST.remove(data);
                data=0;
            }

            AppUtils.writeResponseAsJson(resp,200,data);
        }

    }
}


