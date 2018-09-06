package com.macintoshuser2.tracker.exception;

@SuppressWarnings("serial")
public class DBException extends Exception {
	DBException() {};
	
	public DBException(Exception e) {
		super(e);
	}
}
