package za.ac.cput.mymavemproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VehiclesDbConnection {

    public static Connection derbyConnection() throws SQLException {
        String dbURL = "jdbc:derby://localhost:1527/VEHICLES";
        String username = "Vehicles";
        String password = "1234";

        System.out.println("About to get connection");
        Connection con = DriverManager.getConnection(dbURL, username, password);
        System.out.println("Connection established");
        return con;
    }
}
