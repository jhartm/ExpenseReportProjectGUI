package com.georgeconsulting.expenseReport;

import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class ExpenseListManager {
    public DBConnect conn;

    public  ExpenseListManager() {
    	
    	//FIX FIX FIX - move connection to a shared singleton
        try {
			conn = new DBConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	public void fetchReports( ReportState state ) {
		JdbcRowSet jdbcRs = null;
	    
		try {
			jdbcRs = new JdbcRowSetImpl(conn.conn);
			jdbcRs.setCommand("SELECT empID, contractID, estAir, estGnd, estLodge, estPerdiem, estOther, " +
					"estTotal, requestDate, statusReport FROM TravelExpenseReport WHERE statusRequest = ?");
			jdbcRs.setInt(1, state.getValue() );
			jdbcRs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			jdbcRs.beforeFirst();
			while (jdbcRs.next()) {
				System.err.println( "contractID " + jdbcRs.getString("contractID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block"
			e.printStackTrace();
		}

	}
		
	public static void main( String argv[] ) {
		ExpenseListManager elm = new ExpenseListManager();
		elm.fetchReports( ReportState.PENDING_REPORT);
		
	}
}
