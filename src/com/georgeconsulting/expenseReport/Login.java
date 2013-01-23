
package com.georgeconsulting.expenseReport;

import java.sql.*;
import java.math.*;
import java.security.*;

public class Login {
    int userID = 0;
    Boolean validUser = false;
    
    String queryStmt = "SELECT * FROM Login WHERE username = '";
    
    public void getLogin(DBConnect conn, String inputUsername, String inputPassword) throws SQLException, NoSuchAlgorithmException {
        //Looks up the username in the database for a match
        FetchQuery userLookUp = new FetchQuery(conn.conn, queryStmt + inputUsername + "'");
        
        //Encrypts the typed password using an MD5 algorithm
        MessageDigest mdEnc = MessageDigest.getInstance("MD5");
	mdEnc.update(inputPassword.getBytes(), 0, inputPassword.length());
	String encInputPassword = new BigInteger(1, mdEnc.digest()).toString(16);
        
        //If resultset is empty, username does not exist in DB
        if(!userLookUp.rs.next()) {
            System.out.println("*** WARNING: invalid username ***");
        }
        else {
            //If username matches, checks for a password match
            if(!encInputPassword.equals(userLookUp.rs.getString("password"))) {
                System.out.println("*** WARNING: password does not match username ***");
            }
            else {
                userID = userLookUp.rs.getInt("empID");
                
                validUser = true;
                
//                System.out.println("User ID: " + userID);
            }
        }
    }
}
