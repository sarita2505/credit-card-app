package com.java.utils;

import com.java.model.DatabaseType;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnection {
    //   public static void dataBaseConnection(){
//Connection conn=null;
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("================================");
//            System.out.println("driver class loaded");
//            //conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
//            System.out.println("connection established");
//        }catch (ClassNotFoundException e){
//            System.out.println("driver class is not loaded"+e);
//        }catch (SQLException e){
//            System.out.println("connection is not established"+e);
//        }
//        return conn;

    // }

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionManager.class.getName());
    public static final String URL;
    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        Properties properties = getDatabaseProperty(DatabaseType.ORACLE);
        URL = properties.getProperty("url");
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        String driverClass = properties.getProperty("driverclass");
        try {
            Class.forName(driverClass);
            System.out.println("driver class loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("driver class is not loaded" + e);
        }
    }

    public static Connection establishConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            System.out.println("connection established");
        } catch (SQLException e) {
            System.out.println("connection is not established" + e);
        }
        return connection;

    }
    public static void closeConnection(Connection connection){

        try {
            if(connection!=null)
            {
                connection.close();
            }
        }catch (SQLException e){
        System.out.println(e);}
    }


    public static Properties getDatabaseProperty(DatabaseType databaseType) {
        String filename = getDatabaseTypeFile(databaseType);
        InputStream inputStream = null;
        inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(filename);
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static String getDatabaseTypeFile(DatabaseType databaseType) {
        String filename = null;
        switch (databaseType) {
            case ORACLE:
                filename = "oracle.properties";
                break;
            case MYSQL:
                filename = "mysql.properties";
                break;
            default:
                throw new IllegalArgumentException("unsupported database type");
        }
        return filename;
    }

}
