package com.georgeconsulting.expenseReport;

import java.sql.*;

public class Report {
	int reportID;
	int empID;
	String contractID;
	float estAir = 0;
	float estGnd = 0;
	float estLodge = 0;
	float estPerdiem = 0;
	float estOther = 0;
	float estTotal = 0;
	float actAir = 0;
	float actGnd = 0;
	float actLodge = 0;
	float actPerdiem = 0;
	float actOther = 0;
	float actTotal = 0;
	String requestDate = null;
	String approvalDate = null;
	String completionDate = null;
	int requestStatus = 1;
	int reportStatus = 1;
        
	public void newEntry(DBConnect conn) throws SQLException {
            String insertInto = "INSERT INTO TravelExpenseReport ";
            String insertColumns = "(empID, contractID, estAir, estGnd, estLodge, estPerdiem, estOther, estTotal, requestDate, statusReport) ";
            String insertValues = "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = null;
            stmt = conn.conn.prepareStatement(insertInto + insertColumns + insertValues);
                
            stmt.setInt(1,empID);
            stmt.setString(2,contractID);
            stmt.setFloat(3,estAir);
            stmt.setFloat(4,estGnd);
            stmt.setFloat(5,estLodge);
            stmt.setFloat(6,estPerdiem);
            stmt.setFloat(7,estOther);
            stmt.setFloat(8,estTotal);
            stmt.setString(9,requestDate);
            stmt.setInt(10,reportStatus);
            
            stmt.executeUpdate();
	}
	
	public void viewEntryL1() {
		
	}

    
}
