package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public ConnectionUtil() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Oracle driver not found");
			
		}
	}
	
	public static Connection getConnection() {
		InputStream in = null;
		try{
			Properties props = new Properties();
			in = new FileInputStream("C:\\Users\\mrpra\\Documents\\workspace-sts-3.9.4.RELEASE\\Project11\\src\\main\\resources\\db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
						props.getProperty("jdbc.password"));
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException i) {
				System.err.println("Input Steam Error.." + i.getMessage());
			}
		}
		return null;
	}
}