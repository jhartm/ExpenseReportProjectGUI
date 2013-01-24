package com.georgeconsulting.expenseReport;

import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import java.text.*;
import java.util.*;

public class TravelExpenseReport {
	int reportID;
	int empID;
	int contractID;
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
        
        ArrayList newReqValues = new ArrayList();

	public void newEntry(DBConnect conn, Employee user, ArrayList input) throws SQLException {
            String insertInto = "INSERT INTO TravelExpenseReport ";
            String insertColumns = "(empID, contractID, estAir, estGnd, estLodge, estPerdiem, estOther, estTotal, requestDate, statusReport) ";
            String insertValues = "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
            Populate.newEntry(conn.conn, insertInto + insertColumns + insertValues, input);
	}
	
	public void viewEntryL1() {
		
	}
}
