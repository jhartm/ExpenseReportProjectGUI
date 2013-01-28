package com.georgeconsulting.expenseReport;

public enum ReportState {
	PENDING_REPORT( 1 ),
	APPROVED_REPORT( 2 ),
	REJECTED_REPORT( 3 );
	
	int value;
	
	private ReportState( int value ) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
