package com.macintoshuser2.tracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.macintoshuser2.tracker.exception.DBException;

public class DBUtil {
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws DBException {
		if(connection != null) {
			return connection;
		} else {
			try {
				String url = "jdbc:mysql://localhost:3306/<DB Name Here>";
				String username = "";
				String password = "";
				
				connection = DriverManager.getConnection(url, username, password);
				return connection;
			} catch(SQLException e) {
				throw new DBException(e);
			}
		}
	}
	
	public static synchronized void closeConnection() throws DBException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DBException(e);
            } finally {
                connection = null;                
            }
        }
    }
}