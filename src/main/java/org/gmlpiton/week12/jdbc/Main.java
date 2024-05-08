package org.gmlpiton.week12.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException
    {
        /*final Connection connection = DriverManager.getConnection(url);

        if (connection == null) {
            return;
        }

         */

        final Connection connection = JdbcConnect.getConnection();

        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement("insert into tt.accommodation values (?,?,?,?)"
            );
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "single");
            preparedStatement.setString(3, "sofa");
            preparedStatement.setString(4, "single room sofa bed");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
