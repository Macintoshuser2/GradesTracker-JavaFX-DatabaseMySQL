package com.macintoshuser2.tracker;

import com.macintoshuser2.tracker.events.DeleteButtonClickedEvent;
import com.macintoshuser2.tracker.events.ExecuteQueryButtonClickedEvent;
import com.macintoshuser2.tracker.events.SubmitButtonClickedEvent;
import com.macintoshuser2.tracker.ui.DeleteButton;
import com.macintoshuser2.tracker.ui.QueryButton;
import com.macintoshuser2.tracker.ui.SubmitButton;
import com.macintoshuser2.tracker.ui.TrackerField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.AccessibleRole;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	public Stage stage;
	
	public static TrackerField classNameField;
	public static TrackerField gradeField;
	public static TrackerField teacherFirstNameField;
	public static TrackerField teacherLastNameField;
	public static TrackerField dateChecked;
	
	public SubmitButton submitButton;
	public DeleteButton deleteButton;
	public QueryButton queryButton;
	
	public HBox programControls;
	
	public static GridPane root;
	
	public static VBox queryRoot;
	public static Scene queryScene;
	
	public static HBox controlsForQueryScene;
	
	public static TextField conditionField;
	public static TextField patternField;
	
	public static Button executeQueryButton;
	public static Button backButton;
	
	public static VBox deleteRoot;
	public static Scene deleteScene;
	
	public static HBox controlsForDeleteScene;
	
	public static TextField conditionDeleteField;
	public static TextField patternDeleteField;
	
	public static Button executeDeleteButton;
	public static Button backDeleteButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		
		initComponents();
		
		programControls.getChildren().addAll(submitButton, deleteButton, queryButton);
		
		root.add(new Label("Class: "), 0, 0);
		root.add(classNameField, 1, 0);
		root.add(new Label("Grade: "), 2, 0);
		root.add(gradeField, 3, 0);
		root.add(new Label("First Name: "), 0, 1);
		root.add(teacherFirstNameField, 1, 1);
		root.add(new Label("Last Name: "), 2, 1);
		root.add(teacherLastNameField, 3, 1);
		root.add(new Label("Date: "), 0, 2);
		root.add(dateChecked, 1, 2, 3, 1);
		root.add(programControls, 0, 3, 4, 1);
		
		programControls.setAlignment(Pos.CENTER);
		
		root.setVgap(10);
		root.setHgap(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(root);
		
		submitButton.setOnAction(e -> SubmitButtonClickedEvent.onSubmitButtonClicked(classNameField.getText(), gradeField.getText(), teacherFirstNameField.getText(), teacherLastNameField.getText(), dateChecked.getText()));
		queryButton.setOnAction(e -> primaryStage.setScene(queryScene));
		backButton.setOnAction(e -> primaryStage.setScene(scene));
		deleteButton.setOnAction(e -> primaryStage.setScene(deleteScene));
		backDeleteButton.setOnAction(e -> primaryStage.setScene(scene));
		queryScene = new Scene(queryRoot);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void initComponents() {
		root = new GridPane();
		classNameField = new TrackerField("Class Name", true, "class-name", "class-name", AccessibleRole.TEXT_FIELD, "Class Name Field", "This field is for putting in the name of the class period you'd like to put in the database");
		gradeField = new TrackerField("Grade (Letter and %)", true, "grade", "grade", AccessibleRole.TEXT_FIELD, "Grade Field", "This field is for entering your grade letter and percentage");
		teacherFirstNameField = new TrackerField("First Name", true, "tfn", "tfn", AccessibleRole.TEXT_FIELD, "Teacher First Name Field", "This field is for entering your teacher's first name");
		teacherLastNameField = new TrackerField("Last Name", true, "tln", "tln", AccessibleRole.TEXT_FIELD, "Teacher Last Name Field", "This field is for entering your teacher's last name");
		dateChecked = new TrackerField("Date (MMM DD, YYYY", true, "date-checked", "date-checked", AccessibleRole.TEXT_FIELD, "Date Grades were checked field", "This field if ro entering the day you checked your grades");
		submitButton = new SubmitButton(AccessibleRole.BUTTON);
		deleteButton = new DeleteButton(AccessibleRole.BUTTON);
		queryButton = new QueryButton(AccessibleRole.BUTTON);
		programControls = new HBox(10);
		
		queryRoot = new VBox(30);
		
		conditionField = new TextField();
		conditionField.setPromptText("Condition");
		patternField = new TextField();
		patternField.setPromptText("Pattern");
		
		controlsForQueryScene = new HBox(25);
		executeQueryButton = new Button("Execute Your Query");
		backButton = new Button("Back To Data Entry");
		
		controlsForQueryScene.getChildren().addAll(executeQueryButton, backButton);
		controlsForQueryScene.setAlignment(Pos.CENTER);
		
		queryRoot.setPadding(new Insets(15, 15, 15, 15));
		queryRoot.setAlignment(Pos.CENTER);
		queryRoot.getChildren().add(conditionField);
		queryRoot.getChildren().add(patternField);
		queryRoot.getChildren().add(controlsForQueryScene);
		
		executeQueryButton.setOnAction(e -> ExecuteQueryButtonClickedEvent.onExecuteQueryButtonClicked(conditionField.getText(), patternField.getText()));

		deleteRoot = new VBox(30);
		deleteScene = new Scene(deleteRoot);
		
		conditionDeleteField = new TextField();
		conditionDeleteField.setPromptText("Condition");
		patternDeleteField = new TextField();
		patternDeleteField.setPromptText("Pattern");
		
		controlsForDeleteScene = new HBox(25);
		executeDeleteButton = new Button("Execute Delete");
		backDeleteButton = new Button("Back To Data Entry");
		
		controlsForDeleteScene.getChildren().addAll(executeDeleteButton, backDeleteButton);
		controlsForDeleteScene.setAlignment(Pos.CENTER);
		
		deleteRoot.setPadding(new Insets(15, 15, 15, 15));
		deleteRoot.setAlignment(Pos.CENTER);
		deleteRoot.getChildren().add(conditionDeleteField);
		deleteRoot.getChildren().add(patternDeleteField);
		deleteRoot.getChildren().add(controlsForDeleteScene);
		
		executeDeleteButton.setOnAction(e -> {
			DeleteButtonClickedEvent.onDeleteButtonClicked(conditionField.getText(), patternField.getText());
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
