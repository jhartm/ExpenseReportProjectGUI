package com.georgeconsulting.expenseReport;

import java.sql.*;
import java.util.*;

public class Employee {
	//Employee information fields
	int empID;
	String firstName;	
	String lastName;
	int supervisorID;
	String email;
	int privLevel;
	
	//SQL select statement
	String queryStmt = "SELECT * FROM Employee WHERE empID = ";
	
	//Constructor
	public Employee(int numID, DBConnect conn) throws SQLException {
            //Pulls desired data from SQL database
            FetchQuery getEmp = new FetchQuery(conn.conn, queryStmt+numID);
		
            //Sets class fields and prints to screen
            getEmp.rs.next();
            empID = getEmp.rs.getInt("empID");
            firstName = getEmp.rs.getString("firstNAme");
            lastName = getEmp.rs.getString("lastName");
            supervisorID = getEmp.rs.getInt("supervisorID");
            email = getEmp.rs.getString("email");
            privLevel = getEmp.rs.getInt("privLevel");
	}
        
        public void updateEmpInfo(DBConnect conn, ArrayList newInfo) throws SQLException {
            String updateStmt = "UPDATE Employee ";
            String setStmt = "SET lastName = ?, firstName = ? ";
            String whereStmt = "WHERE empID = ?";
            
            PreparedStatement stmt = null;
            stmt = conn.conn.prepareStatement(updateStmt + setStmt + whereStmt);
                
            stmt.setString(1, newInfo.get(0).toString());
            stmt.setString(2, newInfo.get(1).toString());
            stmt.setInt(3, empID);
            
            stmt.executeUpdate();
            
            lastName = newInfo.get(0).toString();
            firstName = newInfo.get(1).toString();
        }
}
