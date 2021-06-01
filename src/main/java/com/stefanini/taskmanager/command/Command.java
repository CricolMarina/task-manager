package com.stefanini.taskmanager.command;

public interface Command {
	/**
	 * This method is used to get name of the command
	 */
	String getName();
	
	/**
	 * This method is used to execute a command
	 */
	void execute(String [] args);
	}
