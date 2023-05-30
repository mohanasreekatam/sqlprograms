import java.sql.*;
import java.util.Scanner;
public class SwitchStringExample {
    public static void main(String[] args) {

        String  operator, name;
        int id, gpa;

        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/cbit";
        String username = "root";
        String password = "root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            System.out.println("Choose a Operation: add, update, delete");
            operator = input.nextLine();

            switch (operator) {
                case "add":
                    System.out.println("Enter id, name, gpa");
                    id = input.nextInt();
                    gpa = input.nextInt();
                   input.nextLine();
                    name = input.nextLine();
                    String sql2 = String.format("insert into student4 values (%d,'%s',%d);",id,name,gpa);
                    statement.executeUpdate(sql2);
                    System.out.println("addition sucessfully");
                    break;

                case "update":
                    String sql =String.format("update student4 set  name='dfsdf' where id =9 ");
                    statement.executeUpdate(sql);
                    break;

                case "delete":
                    String sql3 =String.format ("delete from student4 where id = 9 ");
                    statement.executeUpdate(sql3);
                    break;

                default:
                    System.out.println("Invalid operation!");
                    break;
            }
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student4");

            while (resultSet.next()) {
                // Process the data here
                String name1 = resultSet.getString("name");
                String gpa1 = resultSet.getString("gpa");
                String id1 = resultSet.getString("id");
//                String department1 = resultSet.getString("id");
                System.out.println(id1 + " " + name1 + " " + gpa1);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e) {
            e.printStackTrace();
 }
}
}