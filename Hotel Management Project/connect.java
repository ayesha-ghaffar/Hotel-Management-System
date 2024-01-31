import java.sql.*;

public class connect {

    Connection connection = null;
    Statement s = null;
    connect(){
        try {
            
            // Load the Oracle JDBC driver
                Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create a connection to the Oracle database
                String url = "jdbc:oracle:thin:@localhost:1521:orcl";
                String username = "hr";
                String password = "hr";
                connection = DriverManager.getConnection(url, username, password);

                //Create statement for executing queries
                s = connection.createStatement();

                System.out.println("Connection established successfully!");
                // Use the connection to perform database operations here...

        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }

        // Add a method to get the connection
        public Connection getConnection() {
            return connection;
        }

       // Add a method to close the connection and statement
       public void closeConnection() {
        try {
            if (s != null) {
                s.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main (String []args){
        connect run = new connect();
    }
}

