package com.stefanini.taskmanager.command;

import java.util.List;

public interface CommandInvoker extends Command{
	/**
	 * This method is used to add a command
	 * @param command
	 */
	void addCommand(Command command);
	
	Command getCommand(String name);
	
	List<Command> getCommands();
}

