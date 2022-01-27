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
import java.sql.SQLException;
import java.sql.CallableStatement;

public class ShowTotalEmpByDeptID {

    public static void main(String[] argv) {
        try {
            oracleStoredProcedure();
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    private static void oracleStoredProcedure() throws SQLException {
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        // Prepared statement to call SQL store procedure
        String procSql = "{call total_emp_by_dept_id(?,?)}";
        // Prompt to user input the department ID
        System.out.print("\nPlease enter a department ID: ");
        Scanner keyboard = new Scanner( System.in );
        String depID = keyboard.nextLine();
        keyboard.close();
        try {
            // Connect to database
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(procSql);
            callableStatement.setInt(1, Integer.parseInt(depID));
            callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC);
            // Execute SQL store procedure
            callableStatement.executeUpdate();
            int empNum = callableStatement.getInt(2);
            System.out.println("\nTotal number of employees in department " + depID + " is " + empNum);
        }
        // If user input is not an integer
        catch (NumberFormatException ne) { System.out.println("\nPlease enter an integer number"); }
        catch (SQLException e) { System.out.println(e.getMessage()); }

        // Close connection
        finally {
            if (callableStatement != null) { callableStatement.close(); }
            if (dbConnection != null) { dbConnection.close(); }
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