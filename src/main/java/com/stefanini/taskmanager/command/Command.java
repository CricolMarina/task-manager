package com.stefanini.taskmanager.command;

public interface Command {
	
	String getName();
	
	/**
	 * This method is used to execute a command
	 */
	
	void execute(String [] args);
	
}
