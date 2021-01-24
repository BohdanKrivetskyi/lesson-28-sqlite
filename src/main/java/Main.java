
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (SQLException e) {
            System.out.println("Failed to do something: " + e.getLocalizedMessage());
        }
    }
    Scanner scanner = new Scanner(System.in);
    String number = "";


    private void run() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:student.db")) {
            while (!"6".equals(number)) {
                System.out.println("menu");
                number = scanner.nextLine().trim();
                int choice = Integer.parseInt(number);

                switch (choice) {
                    case 1:

                }
            }
        }
    }

    private final String menu = "Enter a number from 1 to 6:" +
            " 1 - Create table" +
            " 2 - Add new student" +
            " 3 - Show all students sorted by name" +
            " 4 - Table search" +
            " 5 - Delete table" +
            " 6 - Exit";

}