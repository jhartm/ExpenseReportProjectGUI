package com.georgeconsulting.expensereport;

import java.sql.*;

public class Populate {
	Statement stmt = null;
	
	public static void newEntry(Connection conn, String queryStmt) throws SQLException {
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(queryStmt);
		stmt.executeUpdate(queryStmt);
	}
}
