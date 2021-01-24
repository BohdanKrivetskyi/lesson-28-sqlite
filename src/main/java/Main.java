
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
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:students.db")) {
            while (!"6".equals(number)) {
                System.out.println(menu);
                number = scanner.nextLine().trim();
                int choice = Integer.parseInt(number);

                switch (choice) {
                    case 1:
                        createTable(connection);
                        System.out.println("Table has been created");
                        break;
                    case 2:
                        addNewStudent(connection);
                        System.out.println("Student added");
                        break;
                    case 3:

                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Incorrect value");
                }
            }
        }
    }

    private final String menu = "Enter a number from 1 to 6:" +
            " 1 - Create table\n" +
            " 2 - Add new student\n" +
            " 3 - Show all students sorted by name\n" +
            " 4 - Table search\n" +
            " 5 - Delete table\n" +
            " 6 - Exit";

    private void createTable(Connection connection) throws SQLException {
        final String createStudentTable = "CREATE TABLE IF NOT EXISTS students (" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR(30)" +
                " lastname VARCHAR(30)" +
                " group VARCHAR(20)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createStudent);
        }
    }

    private void addNewStudent(Connection connection) throws SQLException {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student lastane: ");
        String lastname = scanner.nextLine();
        System.out.println("Enter your groug: ");
        String group = scanner.nextLine();
        System.out.println("Enter student faculty: ");
        String faculty = scanner.nextLine();

        final String addStudent =
                "INSERT INTO student (name, lastname, group, faculty" +
                " VALUE ('" + name + "', '" + lastname + "', '" + group + "', '" + faculty + "')";

        Statement statement = connection.createStatement();
            statement.executeUpdate(addStudent);

    }
}