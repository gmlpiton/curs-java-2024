package org.gmlpiton.week12.jdbc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {

    private static Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = JdbcConnect.getConnection();

//        connection.setAutoCommit(false);
    }


    @Test
    void addDataToDatabase_OK() throws SQLException {

        PreparedStatement preparedStatement = null;
        try {


            preparedStatement = connection.prepareStatement("insert into tt.accommodation values (?,?,?,?)"
            );
            preparedStatement.setInt(1, 11);
            preparedStatement.setString(2, "double");
            preparedStatement.setString(3, "queen");
            preparedStatement.setString(4, "double room queen bed");

            int result =
                    preparedStatement.executeUpdate();
            assertEquals(result, 1); // one line should be inserted

            preparedStatement = connection.prepareStatement("insert into tt.room_fair values (?,?,?)"
            );
            preparedStatement.setInt(1, 3);
            preparedStatement.setDouble(2, 99.99);
            preparedStatement.setString(3, "HighSeason");

            result =
                    preparedStatement.executeUpdate();
            assertEquals(result, 1); // one line should be inserted

            preparedStatement = connection.prepareStatement("insert into tt.accommodation_room_fair_relation values (?,?,?)"
            );
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 11);
            preparedStatement.setInt(3, 3);

            result =
                    preparedStatement.executeUpdate();
            assertEquals(result, 1); // one line should be inserted


        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.out.println(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
    }

    @Test
    void selectData_from_DB_OK() throws SQLException {
        PreparedStatement preparedStatement = null;

        Statement statement = null;
        ResultSet resultSet = null;
        final String format = "%5s%40s%40s\n";

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT b.id, c.value, b.description " +
                    "FROM tt.accommodation_room_fair_relation as a \n" +
                    " join tt.accommodation as b\n" +
                    "on a.accommodation_id = b.id\n" +
                    " join tt.room_fair as c\n" +
                    "on a.room_fair_id = c.id \t\n" +
                    "ORDER BY b.id, c.id ASC ");
            boolean hasResults = resultSet.next();

            if (hasResults) {
                System.out.format(format, "Id", "Value", "Description");
                do {
                    System.out.format(
                            format,
                            resultSet.getInt("id"),
                            resultSet.getDouble("value"),
                            resultSet.getString("description")
                    );
                } while (resultSet.next());
            } else {
                System.out.println();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }

    }


    @AfterAll
    static void afterAll() throws SQLException {
        System.out.println("Delete test data!");

        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement("delete from  tt.accommodation_room_fair_relation where id = ?");
            preparedStatement.setInt(1, 3);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("delete from  tt.room_fair where id = ?");
            preparedStatement.setInt(1, 3);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("delete from  tt.accommodation where id = ?");
            preparedStatement.setInt(1, 11);
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
                System.out.println("SQLException when closing db connection in @AfterAll");
            }
        }
    }


}


