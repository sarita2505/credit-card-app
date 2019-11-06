package com.java.utils;

import com.java.model.DatabaseConstants;
import com.java.model.DatabaseType;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnectionManager {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionManager.class.getName());
    public static final String URL;
    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        Properties databaseProperties = getProperties(DatabaseType.ORACLE);

        URL = databaseProperties.getProperty("url");
        USERNAME = databaseProperties.getProperty(DatabaseConstants.USERNAME);
        PASSWORD = databaseProperties.getProperty("password");

        String driverClass = databaseProperties.getProperty(DatabaseConstants.DRIVER_CLASS);

        // loading driverclass
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void rollbackTransaction(Connection con)
    {
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection con) {
        LOGGER.info("closing the connection");
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        LOGGER.info("creating a connection");
        Connection con = null;
        // URL, USERNAME, PASSWORD, DRIVERCLASS
        // From where you will get this? and in which form.
        // Ans: from a file and in a properties collection: oracle.properties or mysql.properties, postgres.properties.
        // How you decide which file you have to pick.
        // Ans: by the database type.

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("connection created");
        return con;
    }

    private static Properties getProperties(DatabaseType databaseType) {
        String fileName = getDatabaseFileName(databaseType);
        InputStream is = null;
        is = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream(fileName);

        Properties databaseProperties = new Properties();
        try {
            databaseProperties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return databaseProperties;
    }

    private static String getDatabaseFileName(DatabaseType databaseType) {
        String fileName = null;
        switch (databaseType) {
            case ORACLE:
                fileName = "oracle.properties";
                break;
            case MYSQL:
                fileName = "mysql.properties";
                break;
            default:
                throw new IllegalArgumentException("Unsupported DatabaseType: " + databaseType);
        }
        return fileName;
    }


}
