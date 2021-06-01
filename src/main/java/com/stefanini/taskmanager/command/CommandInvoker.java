package com.stefanini.taskmanager.command;

public interface CommandInvoker extends Command{
	/**
	 * This method is used to add a command
	 * @param command
	 */
	void addCommand(Command command);
	}
