
package com.georgeconsulting.expenseReport;

import java.sql.*;
import java.math.*;
import java.security.*;

public class Login {
    int userID = 0;
    Boolean validUser = false; 
    
    String queryStmt = "SELECT * FROM Login";
    
    public void getLogin(DBConnect conn, String inputUsername, String inputPassword) throws SQLException, NoSuchAlgorithmException {
        //Looks up the username in the database for a match
        FetchQuery userLookUp = new FetchQuery(conn.conn, queryStmt);
        
        //Encrypts the typed password using an MD5 algorithm
        MessageDigest mdEnc = MessageDigest.getInstance("MD5");
	mdEnc.update(inputPassword.getBytes(), 0, inputPassword.length());
	String encInputPassword = new BigInteger(1, mdEnc.digest()).toString(16);
        
        //Validates the username and password
        while(userLookUp.rs.next()) {
            if(inputUsername.equals(userLookUp.rs.getString("username"))) {
                 if(encInputPassword.equals(userLookUp.rs.getString("password"))) {
                     validUser = true;
                     
                     userID = userLookUp.rs.getInt("empID");
                 }
            }
        }
    }
}
