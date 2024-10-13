package za.ac.cput.mymavemproject.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 *
 * @author Engetelo
 */
public class VehicleDAO {

    private Connection con;

    public void createTable() throws Exception {
        String createTable = "CREATE TABLE Vehicles (Votes_count INTEGER, Car_names VARCHAR(50))";
        Statement stmt = con.createStatement();
        stmt.execute(createTable);
        System.out.println("Table created successfully");

    }

    public void addValues(String name) {

        String query = "INSERT INTO VEHICLES( Votes_count, Car_names) VALUES(?,?)";
        try (Connection con = VehiclesDbConnection.derbyConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("work please");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void updateVotes() {
    }

    public void retrieveValues() {

    }

    public void closeConnection() throws Exception {

        con.close();

    }

}
