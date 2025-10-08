import java.sql.*;
public class JDBCExample {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/schooldb";
        String user = "root";
        String password = "Priya@8888";
        // SQL query
        String query = "SELECT id, name, age, grade FROM students";
        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 2: Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully!");
            // Step 3: Create a statement
            Statement stmt = conn.createStatement();
            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery(query);
            // Step 5: Process the results
            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                System.out.println("ID: " + id + ", Name: " + name +
                        ", Age: " + age + ", Grade: " + grade);
            }
            // Step 6: Close connections
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\n Connection closed.");
        } catch (ClassNotFoundException e) {
            System.out.println(" MySQL Driver not found. Please add the connector JAR file.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Database error occurred!");
            e.printStackTrace();
        }
    }
}
