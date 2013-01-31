package com.georgeconsulting.expenseReport;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;

import javax.sql.rowset.JdbcRowSet;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
	JComboBox statusList;
	JTable table;
	String columnNames[] = { "Emp. ID", "Contract", "Est. Air", "Est. Ground", "Est. Lodging", "Est. Per Diem", "Est. Other",
			"Est. Total", "Request Date", "Status Report" };

	
    public  ExpenseListManager()  {
    	
    	//FIX FIX FIX - move connection to a shared singleton
        try {
			conn = new DBConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	protected void reportStatusChanged() {
		showReport( (ReportState) statusList.getSelectedItem() );
	}

	void showReport( ReportState state ) {
    	fetchReports(state);
        fireTableDataChanged();		
        table.revalidate();
        table.repaint();
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
		
	 
	 @Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {		
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return numberOfCols;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
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


	public static void main( String argv[] ) {
		final ExpenseListManager elm = new ExpenseListManager();
		elm.fetchReports( ReportState.PENDING_REPORT);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                elm.createAndShowGUI();
            }
        });
		
	}
	
	private void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Expense List Viewer");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        table = new JTable(this);
	        table.setPreferredScrollableViewportSize(new Dimension(700, 350));
	        table.setFillsViewportHeight(true);
	        TableColumn column = table.getColumnModel().getColumn(8);
//	        column.setCellRenderer( new DateRenderer() );
	 
	    	statusList = new JComboBox(ReportState.values());
	    	statusList.setMaximumSize(new Dimension(150, 30));
	    	//Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(table);
	 
	        JPanel buttonPane = new JPanel();
	        buttonPane.setLayout( new BoxLayout(buttonPane, BoxLayout.Y_AXIS) );
	        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
	        buttonPane.add(statusList);
	        buttonPane.add(Box.createVerticalGlue());
	        buttonPane.add(Box.createRigidArea(new Dimension(0,15)));
	        
	        statusList.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	reportStatusChanged();
	            }
	        });
	        
	        JPanel panel = new JPanel();
	        panel.setLayout( new BorderLayout() );
	        panel.add(buttonPane, BorderLayout.WEST );
	        panel.add(scrollPane, BorderLayout.CENTER );
	        panel.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(panel);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	
	static class DateRenderer extends DefaultTableCellRenderer {
	    DateFormat formatter;
	    public DateRenderer() { super(); }

	    public void setValue(Object value) {
	        if (formatter==null) {
	            formatter = DateFormat.getDateInstance();
	        }
	        setText((value == null) ? "" : formatter.format(value));
	    }
	}
}
