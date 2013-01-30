package com.georgeconsulting.expenseReport;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.persistence.platform.database.FirebirdPlatform;

import com.sun.rowset.JdbcRowSetImpl;

public class ExpenseListManager extends DefaultTableModel implements TableModel {
	private static final long serialVersionUID = 864061271933682004L;
	DBConnect conn;
	JdbcRowSet jdbcRs;
    ResultSetMetaData metadata;
    int numberOfRows;
    int numberOfCols;
    
    public  ExpenseListManager()  {
    	
    	//FIX FIX FIX - move connection to a shared singleton
        try {
			conn = new DBConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	public void fetchReports( ReportState state ) {
	    
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
			metadata = jdbcRs.getMetaData();
			numberOfCols = metadata.getColumnCount();
			numberOfRows = 0;
			while( jdbcRs.next() ) 
				numberOfRows++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void main( String argv[] ) {
		ExpenseListManager elm = new ExpenseListManager();
		elm.fetchReports( ReportState.PENDING_REPORT);
		
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		return numberOfCols;
	}

	@Override
	public String getColumnName(int col) {
	    try {
	        return metadata.getColumnLabel(col + 1);
	      } catch (SQLException e) {
	        return e.toString();
	      }
	}

	@Override
	public int getRowCount() {
		return numberOfRows;
	}

	@Override
	//TODO fix types being returned
	public Object getValueAt(int rowIndex, int columnIndex) {
	    try {
	        jdbcRs.absolute(rowIndex + 1);
	        Object o = jdbcRs.getObject(columnIndex + 1);
	        if (o == null)
	          return null;
	        else
	          return o.toString();
	      } catch (SQLException e) {
	        return e.toString();
	      }
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public void viewBecameActive() {
        fetchReports( ReportState.PENDING_REPORT);
        fireTableDataChanged();		
	}
}
