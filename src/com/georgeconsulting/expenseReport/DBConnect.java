package com.georgeconsulting.expenseReport;

import java.sql.*;

public class DBConnect {
    //Creates a new connection
    Connection conn;
	
    //Database access fields
    String url = "jdbc:mysql://192.168.1.106:3306/expenseReport";
    String password = "root";
    String user = "jhartmann";
	
    //Constructor
    public DBConnect() throws SQLException {
        try {
            //Dynamically loads class named "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");
		
            //Sets the connection
            conn = DriverManager.getConnection(url,user,password);
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
	}
    }
}
