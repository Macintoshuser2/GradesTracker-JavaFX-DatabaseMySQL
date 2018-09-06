package com.macintoshuser2.tracker.events;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.macintoshuser2.tracker.Grade;
import com.macintoshuser2.tracker.exception.DBException;
import com.macintoshuser2.tracker.util.DBUtil;

public class DeleteButtonClickedEvent {
public static List<Grade> queryResult = null;
	
	public static void onDeleteButtonClicked(String condition, String pattern) {
		executeDelete(condition, pattern);
	}
	
	private static void executeDelete(String condition, String pattern) {
		if(condition.isEmpty() && pattern.isEmpty()) {
			try {
				deleteAll();
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				delete(condition, pattern);
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void deleteAll() throws SQLException, DBException {
		String sql = "DELETE FROM Grade";
		Connection connection = DBUtil.getConnection();
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
	}
	
	private static void delete(String condition, String pattern) throws DBException, SQLException {
		String sql = "";
		
		
		if(condition.isEmpty() && !pattern.isEmpty()) {
			sql = "DELETE FROM Grade WHERE DateChecked LIKE" + pattern;
			Connection connection = DBUtil.getConnection();
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} else if(!condition.isEmpty() && pattern.isEmpty()) {
			sql = "DELETE FROM Grade WHERE " + condition;
			Connection connection = DBUtil.getConnection();
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} else {
			sql = "DELETE FROM Grade WHERE " + condition + " LIKE " + pattern;
			Connection connection = DBUtil.getConnection();
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		}
	}
}
