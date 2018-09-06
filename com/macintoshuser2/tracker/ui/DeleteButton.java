package com.macintoshuser2.tracker.ui;

import javafx.scene.AccessibleRole;
import javafx.scene.control.Button;

public class DeleteButton extends Button {
	public DeleteButton(AccessibleRole role) {
		super("Delete");
		this.setAccessibleRole(AccessibleRole.BUTTON);
	}
}
