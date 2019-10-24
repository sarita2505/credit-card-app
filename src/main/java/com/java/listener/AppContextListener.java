package com.java.listener;

import com.java.context.AppContext;
import com.java.utils.DatabaseConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            Class.forName(AppContext.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // create and close a dummy connection so that further connections faster
        // with this we are validating that we are able to connect to the database on receiving any requuest.

        Connection con = DatabaseConnectionManager.getConnection();
        DatabaseConnectionManager.close(con);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
