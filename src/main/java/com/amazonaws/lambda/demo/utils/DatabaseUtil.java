package com.amazonaws.lambda.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	// These are to be configured and NEVER stored in the code.
		// once you retrieve this code, you can update
		public final static String rdsMySqlDatabaseUrl = "dbx.ct2g145xih78.us-east-2.rds.amazonaws.com";
		public final static String dbUsername = "admin";
		public final static String dbPassword = "t3chnic5123";
			
		public final static String jdbcTag = "jdbc:mysql://";
		public final static String rdsMySqlDatabasePort = "3306";
		public final static String multiQueries = "?allowMultiQueries=true";
		public final static String dbName = "projectdb";    // default created from MySQL WorkBench

		// pooled across all usages.
		static Connection conn;
	 
		/**
		 * Singleton access to DB connection to share resources effectively across multiple accesses.
		 */
		public static Connection connect() throws Exception {
			if (conn != null) { return conn; }
			
			try {
				conn = DriverManager.getConnection(
						jdbcTag + rdsMySqlDatabaseUrl + ":" + rdsMySqlDatabasePort + "/" + dbName + multiQueries,
						dbUsername,
						dbPassword);
				return conn;
			} catch (Exception ex) {
				throw new Exception("Failed in database connection" + ex);
			}
		}
}