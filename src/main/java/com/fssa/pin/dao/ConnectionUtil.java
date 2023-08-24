package com.fssa.pin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {
	private ConnectionUtil() {}
	 /*
     * This class provides a utility method for obtaining a database connection.
     * The getConnection() method retrieves connection details from environment variables or a .env file.
     * It returns a Connection object for interacting with the database.
     */
	public static Connection getConnection() throws SQLException {
		String dbUrl;
		String dbUser;
		String dbPassword;
		if (System.getenv("CI") != null) {
			dbUrl = System.getenv("DB_URL");
			dbUser = System.getenv("DB_USER");
			dbPassword = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			dbUrl = env.get("DB_URL");
			dbUser = env.get("DB_USER");
			dbPassword = env.get("DB_PASSWORD");
		}
		// Connecting to DB
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}

}
