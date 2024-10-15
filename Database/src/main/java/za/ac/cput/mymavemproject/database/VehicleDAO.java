package za.ac.cput.mymavemproject.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehicleDAO {

    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;

    public VehicleDAO() {
        try {
            this.con = VehiclesDbConnection.derbyConnection();

        } catch (Exception ex) {
            System.out.println("Warning " + ex.getMessage());

        }

    }

    // Create the table 
    public void createTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS Vehicles (Votes_count INTEGER, Car_names VARCHAR(50))";
        try (Statement stmt = con.createStatement()) {
            stmt.execute(createTable);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println("Table creation error: " + e.getMessage());

        }
    }

    // Insert values into the table
    public void addValues(int votes, String name) throws SQLException {
        String query = "INSERT INTO Vehicles (Votes_count, Car_names) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, votes);
            pst.setString(2, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insertion error: " + e.getMessage());

        }
    }

    public void updateVehicles(int Votes_count) throws SQLException {
        String query = "UPDATE Vehicles SET Votes_count = Votes_count + ? WHERE id = ? ";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, Votes_count);
            pstmt.executeUpdate();

        }
    }

    public void retrieveResults(String Car_names, int Votes_count) throws SQLException {
        String query = "SELECT * FROM VEhicles ";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            int row = 0;
            if (rs != null) {
                while (rs.next()) {

                    row++;
                    int count = rs.getInt("Votes_count");
                    String name = rs.getString("Car_names");
                     System.out.println("Votes count" + count + "Car names" + name);

                   // System.out.println("Data" + row +":"+ rs.getInt(Car_names) + rs.getString(Car_names));
                }
                rs.close();

            }
        }

    }

    public void closeConnection() throws SQLException {
        con.close();
        stmt.close();
        pstmt.close();

    }
}
