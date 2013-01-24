package com.georgeconsulting.expenseReport;

import java.sql.*;
import java.util.*;

public class Populate {
	Statement stmt = null;
	
	public static void newEntry(Connection conn, String queryStmt, ArrayList input) throws SQLException {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(queryStmt);
                
//            stmt.setInt(1,input.get(0));
            stmt.setInt(2, 3);
                
            stmt.executeUpdate(queryStmt);
	}
}
