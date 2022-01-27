/**********************************************
 Workshop # 10
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    18-04-2021
 **********************************************/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ShowEmpInfoByID {

    public static void main(String args[]) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        // Prompt to user input the employee ID
        System.out.print("\nPlease enter the employee ID: ");
        Scanner keyboard = new Scanner( System.in );
        String userInput = keyboard.nextLine();
        keyboard.close();
        try {
            // Connect to database
            connection = getDBConnection();
            // Prepared statement creation
            String query = "SELECT FIRST_NAME, LAST_NAME, EMAIL, SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
            pStatement = connection.prepareStatement(query);
            // Query parameters
            pStatement.setInt(1, Integer.parseInt(userInput));
            // Query execution
            resultSet = pStatement.executeQuery();
            // Result displaying
            while (resultSet.next()) {
                System.out.print("\nEmployee name:\t");
                System.out.print(resultSet.getString("First_Name").trim() + " ");
                System.out.print(resultSet.getString("Last_Name").trim() + "\t\t");
                System.out.print("\nEmail:\t\t\t");
                System.out.print(resultSet.getString("Email").trim() + "\t\t");
                System.out.print("\nSalary:\t\t\t");
                System.out.println(resultSet.getDouble("Salary"));
            }
        }
        // If user input is not an integer
        catch (NumberFormatException ne) { System.out.println("\nPlease enter an integer number"); }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception: " + e.getMessage());
        }
        // Close connection
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pStatement != null) pStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
            }
        }
    }
    // Connection to the database
    private static Connection getDBConnection() {
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection dbConnection = null;
        try {
            fis = new FileInputStream("db.properties");
            props.load(fis);
            Class.forName(props.getProperty("DB_DRIVER"));
            dbConnection = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
        } catch (IOException | ClassNotFoundException | SQLException e) { System.out.println(e.getMessage()); }
        return dbConnection;
    }

}