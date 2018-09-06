package com.macintoshuser2.tracker.ui;

import javafx.scene.AccessibleRole;
import javafx.scene.control.Button;

public class SubmitButton extends Button {
	public SubmitButton(AccessibleRole role) {
		super("Submit");
		this.setAccessibleRole(AccessibleRole.BUTTON);
	}
}
