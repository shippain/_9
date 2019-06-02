package gsu.math.alex.lab.repository;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static Connection connection;

    @SneakyThrows
    public Connection getConnection(){
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sales?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "alexroot");
        }


        return connection;
    }
}
