package NesteRundeKalkulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NesteRundeHandler {
    
    public void saveSession(Session session, String filename) throws FileNotFoundException {
        try(PrintWriter writer=new PrintWriter(new File(getFilePath(filename)))) {
            
            writer.println("YOYOYO");
        }


    }

    public void getSession(String filename) throws FileNotFoundException {
            try(Scanner reader=new Scanner(new File(getFilePath(filename)))) {

            }
    }

    public static String getFilePath(String filename) {
        System.out.println(NesteRundeHandler.class.getResource("").getFile() + filename + ".txt");
        return NesteRundeHandler.class.getResource("").getFile() + filename + ".txt";
    }

    public static void main(String[] args) throws FileNotFoundException {
        NesteRundeHandler handler = new NesteRundeHandler();
        Session session = new Session("samf");

        handler.saveSession(session, "savedSessions");
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
