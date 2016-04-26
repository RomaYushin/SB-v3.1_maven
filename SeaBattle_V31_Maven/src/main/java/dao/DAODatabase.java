/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Roman
 */
public class DAODatabase {
    private static final String CONNECTION_USER = "root";
    private static final String CONNECTION_PASSWORD = "1111";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/web?zeroDateTimeBehavior=convertToNull";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";    
    private static DAODatabase daoDatabaseInstance;    
    private static Connection connection;

    public DAODatabase() {
        try {
            Class.forName(DRIVER_NAME); // Регистрация драйвера
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }

    public static String getDRIVER_NAME() {
        return DRIVER_NAME;
    }

    public static DAODatabase getDaoDatabaseInstance() {
        synchronized (DAODatabase.class) {
            if (daoDatabaseInstance == null) {
                daoDatabaseInstance = new DAODatabase();
            }
        }
        return daoDatabaseInstance;
    }
    
    public void open() throws SQLException {
        
    }
    
    
}
