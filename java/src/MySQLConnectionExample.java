
import java.sql.*;

public class MySQLConnectionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cbit";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()) {
                // Process the data here
                String data = resultSet.getString("department");
                System.out.println(data);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
 }
}
}