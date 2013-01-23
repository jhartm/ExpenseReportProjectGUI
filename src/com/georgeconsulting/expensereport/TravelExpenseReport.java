package com.georgeconsulting.expensereport;

import java.sql.*;
import java.util.Scanner.*;
import java.util.Date;
import java.text.*;

public class TravelExpenseReport {
	int reportID;
	int empID;
	int contractID;
	int estAir = 0;
	int estGnd = 0;
	int estLodge = 0;
	int estPerdiem = 0;
	int estOther = 0;
	int estTotal = 0;
	int actAir = 0;
	int actGnd = 0;
	int actLodge = 0;
	int actPerdiem = 0;
	int actOther = 0;
	int actTotal = 0;
	String requestDate = null;
	Date approvalDate = null;
	Date completionDate = null;
	int requestStatus = 1;
	int reportStatus = 1;

	public void newEntry(Connection conn, Employee user) throws SQLException {
		empID = user.empID;
		
		Date todaysDate = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		requestDate = ft.format(todaysDate);
		
		Boolean done = false;
		
				

		
			System.out.println("Enter estimated expenses ($):");
			System.out.println("Air Transportation: ");
			estAir = Integer.parseInt(readInput.nextLine());
			System.out.println("Ground Transportation: ");
			estGnd = Integer.parseInt(readInput.nextLine());
			System.out.println("Lodging: ");
			estLodge = Integer.parseInt(readInput.nextLine());
			System.out.println("Per Diem: ");
			estPerdiem = Integer.parseInt(readInput.nextLine());
			System.out.println("Other: ");
			estOther = Integer.parseInt(readInput.nextLine());
			
			estTotal = estAir + estGnd + estLodge + estPerdiem +estOther;
			reportStatus = 2;
			
			System.out.println("Is everything correct? (Y/N)");
			if(readInput.nextLine().equalsIgnoreCase("Y")) {
				done = true;
			}
		}
		
		System.out.println("-------------------------------------------");
		String queryStmt = "INSERT INTO " + "TravelExpenseReport " + 
				"(empID, contractID, estAir, estGnd, estLodge, estPerdiem," +
				"estOther, estTotal, requestDate, statusReport)" +
				"VALUES(" + empID + "," + contractID + "," + estAir + "," + estGnd + "," +
				estLodge + "," + estPerdiem + "," + estOther + "," + estTotal +
				", '" + requestDate + "'," + reportStatus + ")";
		Populate.newEntry(conn, queryStmt);
	}
	
	public void viewEntryL1() {
		
	}
}
