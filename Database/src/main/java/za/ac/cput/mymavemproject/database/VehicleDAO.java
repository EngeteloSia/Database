package za.ac.cput.mymavemproject.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class VehicleDAO {

    // Create the table if not already existing
    public void createTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS Vehicles (Votes_count INTEGER, Car_names VARCHAR(50))";
        try (Connection con = VehiclesDbConnection.derbyConnection(); 
             Statement stmt = con.createStatement()) {
            stmt.execute(createTable);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println("Table creation error: " + e.getMessage());
            throw e;
        }
    }

    // Insert values into the table
    public void addValues(int votes, String name) throws SQLException {
        String query = "INSERT INTO Vehicles (Votes_count, Car_names) VALUES (?, ?)";
        try (Connection con = VehiclesDbConnection.derbyConnection(); 
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, votes);
            pst.setString(2, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insertion error: " + e.getMessage());
            throw e;
        }
    }
}
