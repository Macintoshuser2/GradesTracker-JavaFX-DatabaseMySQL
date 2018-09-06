package com.macintoshuser2.tracker.ui;

import javafx.scene.AccessibleRole;
import javafx.scene.control.TextField;

public class TrackerField extends TextField {

	public TrackerField(String promptText, boolean editable, String id, String className, AccessibleRole role, String accessibleText, String accessibleHelpText) {
		super();
		setPromptText(promptText);
		setEditable(editable);
		setId(id);
		getStyleClass().add(className);
		setAccessibleRole(role);
		setAccessibleText(accessibleText);
		setAccessibleHelp(accessibleHelpText);
	}
}
