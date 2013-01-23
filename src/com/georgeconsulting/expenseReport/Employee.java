package com.georgeconsulting.expenseReport;

import java.sql.*;

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
			
//		System.out.println("Employee: " + firstName + " " + lastName);
//		System.out.println("ID Number: " + empID);
//		System.out.println("Supervisor's ID: " + supervisorID);
//		System.out.println("Email: " + email);
//		System.out.println("Access Level: " + privLevel);
//		System.out.println("-------------------------------------------");
	}
        
        public void updateEmpInfo(DBConnect conn) {
            
        }
}
