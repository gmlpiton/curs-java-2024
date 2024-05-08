package org.gmlpiton.week12.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcConnect {

    private JdbcConnect() {
            }

public static Connection getConnection() throws SQLException {
    System.out.println("Getting connection");
    String url = new StringBuilder()
            .append("jdbc:")
            .append("postgresql") // “mysql” / “db2” / “mssql” / “oracle” / ...
            .append("://")
            .append("localhost")
            .append(":")
            // In your case it will be 5432
            //            .append("5432")
            .append("5432")
            .append("/")
            .append("test")
            .append("?user=")
            .append("postgres")
            .append("&password=")
            .append("test").toString();

    System.out.println("URL: " + url);
    System.out.println();

    return DriverManager.getConnection(url);

}


}
