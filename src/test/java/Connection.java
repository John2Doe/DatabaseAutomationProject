import io.cucumber.datatable.DataTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Connection {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@tgbatch-3.cup7q3kvh5as.us-east-2.rds.amazonaws.com:1521/ORCL";
        String username = "momen";
        String password = "momen123!";
        String query = "select * from employees";

        // Creating the  connection to database with the parameters
        java.sql.Connection connection = DriverManager.getConnection(url, username, password);

        System.out.println("System should be able to connect to the database");

        // Statement keeps the connection between my machine and database
        Statement statement = connection.createStatement();

        // Sending the query to database
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Object> list = new ArrayList<>();

        while (resultSet.next()) {
            String firstName = resultSet.getString("FIRST_NAME");
            list.add(firstName);
            firstName = null;
        }
        System.out.println(list);

    }
}
