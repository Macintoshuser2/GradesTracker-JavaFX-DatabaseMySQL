package com.macintoshuser2.tracker.events;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.macintoshuser2.tracker.Grade;
import com.macintoshuser2.tracker.exception.DBException;
import com.macintoshuser2.tracker.util.DBUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExecuteQueryButtonClickedEvent {
	public static List<Grade> queryResult = null;
	
	public static void onExecuteQueryButtonClicked(String condition, String pattern) {
		executeQuery(condition, pattern);
	}
	
	private static void executeQuery(String condition, String pattern) {
		if(condition.isEmpty() && pattern.isEmpty()) {
			try {
				queryResult = getAll();
				
				createTable(queryResult);
			} catch (DBException e) {
				e.printStackTrace();
			}
		} else {
			try {
				queryResult = get(condition, pattern);
				
				createTable(queryResult);
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void createTable(List<Grade> grade) {
		Stage stage = new Stage();
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		TableView view = new TableView();
		TableColumn className = new TableColumn("Class Name");
		TableColumn classGrade = new TableColumn("Class Grade");
		TableColumn teacherFirstName = new TableColumn("Teacher's First Name");
		TableColumn teacherLastName = new TableColumn("Teacher's Last Name");
		TableColumn dateChecked = new TableColumn("Date Checked");
		
		view.getColumns().addAll(className, classGrade, teacherFirstName, teacherLastName, dateChecked);
		root.setCenter(view);
		
		for(Object tc : view.getColumns().toArray()) {
			((TableColumn) tc).setPrefWidth(200);
			((TableColumn) tc).setEditable(false);
		}
		
		ObservableList<Grade> data = FXCollections.observableArrayList();
		
		for(Grade g : grade) {
			data.add(g);
		}
		
		className.setCellValueFactory(new PropertyValueFactory<Grade, String>("className"));
		classGrade.setCellValueFactory(new PropertyValueFactory<Grade, String>("classGrade"));
		teacherFirstName.setCellValueFactory(new PropertyValueFactory<Grade, String>("teacherFirstName"));
		teacherLastName.setCellValueFactory(new PropertyValueFactory<Grade, String>("teacherLastName"));
		dateChecked.setCellValueFactory(new PropertyValueFactory<Grade, String>("dateGradesChecked"));
		
		view.setItems(data);
		
		stage.setScene(scene);
		stage.show();
		
	}

	private static List<Grade> getAll() throws DBException {
		String sql = "SELECT * FROM Grade ORDER BY GradeID";
		List<Grade> result = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		
		try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				String className = rs.getString("Class");
				String gradeValue = rs.getString("Grade");
				String firstName = rs.getString("TeacherFirstName");
				String lastName = rs.getString("TeacherLastName");
				String dateChecked = rs.getString("DateChecked");

				Grade grade = new Grade();
				grade.setClassName(className);
				grade.setClassGrade(gradeValue);
				grade.setTeacherFirstName(firstName);
				grade.setTeacherLastName(lastName);
				grade.setDateGradesChecked(dateChecked);
				result.add(grade);
			}
			
			return result;
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
	}
	
	private static List<Grade> get(String condition, String pattern) throws DBException {
		String sql = "";
		
		if(condition.isEmpty() && !pattern.isEmpty()) {
			sql = "SELECT * FROM Grade WHERE DateChecked LIKE" + pattern;
			List<Grade> result = new ArrayList<>();
			Connection connection = DBUtil.getConnection();
			
			try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					String className = rs.getString("Class");
					String gradeValue = rs.getString("Grade");
					String firstName = rs.getString("TeacherFirstName");
					String lastName = rs.getString("TeacherLastName");
					String dateChecked = rs.getString("DateChecked");
					
					Grade grade = new Grade();
					grade.setClassName(className);
					grade.setClassGrade(gradeValue);
					grade.setTeacherFirstName(firstName);
					grade.setTeacherLastName(lastName);
					grade.setDateGradesChecked(dateChecked);
					result.add(grade);
				}
				
				return result;
			} catch(SQLException e) {
				throw new DBException(e);
			}
		} else if(!condition.isEmpty() && pattern.isEmpty()) {
			sql = "SELECT * FROM Grade WHERE " + condition;
			List<Grade> result = new ArrayList<>();
			Connection connection = DBUtil.getConnection();
			
			try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					String className = rs.getString("Class");
					String gradeValue = rs.getString("Grade");
					String firstName = rs.getString("TeacherFirstName");
					String lastName = rs.getString("TeacherLastName");
					String dateChecked = rs.getString("DateChecked");
					
					Grade grade = new Grade();
					grade.setClassName(className);
					grade.setClassGrade(gradeValue);
					grade.setTeacherFirstName(firstName);
					grade.setTeacherLastName(lastName);
					grade.setDateGradesChecked(dateChecked);
					result.add(grade);
				}
				
				return result;
			} catch(SQLException e) {
				throw new DBException(e);
			}
		} else {
			sql = "SELECT * FROM Grade WHERE " + condition + " LIKE " + pattern;
			List<Grade> result = new ArrayList<>();
			Connection connection = DBUtil.getConnection();
			
			try(PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					String className = rs.getString("Class");
					String gradeValue = rs.getString("Grade");
					String firstName = rs.getString("TeacherFirstName");
					String lastName = rs.getString("TeacherLastName");
					String dateChecked = rs.getString("DateChecked");
					
					Grade grade = new Grade();
					grade.setClassName(className);
					grade.setClassGrade(gradeValue);
					grade.setTeacherFirstName(firstName);
					grade.setTeacherLastName(lastName);
					grade.setDateGradesChecked(dateChecked);
					result.add(grade);
				}
				
				return result;
			} catch(SQLException e) {
				throw new DBException(e);
			}
		}
	}
}
