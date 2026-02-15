package org.example;
import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/contact_db";
    private static final String USER = "kikex_francis"; // Change to your DB username
    private static final String PASS = "12345678"; // Change to your DB password

    static {
        try {
            // This manually registers the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver not found!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void addContact(String name, String phone, String type) {
        String query = "INSERT INTO contacts (name, phone, type) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, type);
            preparedStatement.executeUpdate();
            System.out.println("✔ Contact saved successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error saving contact: " + e.getMessage());
        }
    }

    public void viewContacts() {
        String query = "SELECT * FROM contacts";
        System.out.printf("\n%-5s | %-15s | %-15s | %-10s\n", "ID", "Name", "Phone", "Type");
        System.out.println("---------------------------------------------------------");
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.printf("%-5d | %-15s | %-15s | %-10s\n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching contacts: " + e.getMessage());
        }
    }

    public void deleteContact(int id) {
        String query = "DELETE FROM contacts WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("✔ Contact deleted successfully!");
            } else {
                System.out.println("⚠ No contact found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }

}
//
//if (rs.next()) {
//        System.out.println("\n--- Contact Found ---");
//            System.out.printf("ID:    %d\n", rs.getInt("id"));
//        System.out.printf("Name:  %s\n", rs.getString("name"));
//        System.out.printf("Phone: %s\n", rs.getString("phone"));
//        System.out.printf("Type:  %s\n", rs.getString("type"));
//        } else {
//        System.out.println("⚠ No contact exists with ID: " + id);
//        }