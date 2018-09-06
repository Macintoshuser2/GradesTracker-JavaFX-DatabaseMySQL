package com.macintoshuser2.tracker.ui;

import javafx.scene.AccessibleRole;
import javafx.scene.control.Button;

public class QueryButton extends Button {
	public QueryButton(AccessibleRole role) {
		super("Query Grades");
		this.setAccessibleRole(AccessibleRole.BUTTON);
	}
}
