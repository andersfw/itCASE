package NesteRundeKalkulator;

public class NesteRundeHandler {
    
    public void saveToDatabase() {

    }

    public void getDatabase() {

    }

}

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class SQLiteConnectionExample {
//     public static void main(String[] args) {
//         Connection connection = null;

//         try {
//             // Load the SQLite JDBC driver
//             Class.forName("org.sqlite.JDBC");

//             // Connect to the SQLite database
//             String url = "jdbc:sqlite:/path/to/your/database.db"; // Replace with your database path
//             connection = DriverManager.getConnection(url);

//             if (connection != null) {
//                 System.out.println("Connected to the SQLite database.");
//                 // You can perform database operations here
//             } else {
//                 System.out.println("Failed to connect to the database.");
//             }
//         } catch (ClassNotFoundException | SQLException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (connection != null) {
//                     connection.close();
//                 }
//             } catch (SQLException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
