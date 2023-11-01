package com.tcc.needahaircut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {

        if (connection == null) {
            connection = DriverManager.getConnection( //
                    "jdbc:mysql://localhost:3306/banco_ineedahaircut_joao", //
                    "root", //
                    "");
        }

        return connection;
    }
}
