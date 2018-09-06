package com.macintoshuser2.tracker.events;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.macintoshuser2.tracker.Main;
import com.macintoshuser2.tracker.exception.DBException;
import com.macintoshuser2.tracker.util.DBUtil;

import javafx.scene.Node;
import javafx.scene.control.TextField;

public class SubmitButtonClickedEvent {
	public static void onSubmitButtonClicked(String className, String classGrade, String firstName, String lastName, String dateGradesChecked) {
		String sqlInsert = 
				"INSERT INTO Grade " +
				"(Class, Grade, TeacherFirstName, TeacherLastName, DateChecked) " +
				"VALUES (?, ?, ?, ?, ?)";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sqlInsert);
			ps.setString(1, className);
			ps.setString(2, classGrade);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, dateGradesChecked);
			ps.executeUpdate();
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Node tf : Main.root.getChildren()) {
			if(tf instanceof TextField) {
				((TextField) tf).clear();
			}
		}
	}
}
