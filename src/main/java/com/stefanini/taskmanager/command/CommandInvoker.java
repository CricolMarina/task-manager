package com.stefanini.taskmanager.command;

import java.util.List;

public interface CommandInvoker extends Command{
	/**
	 * This method is used to add a command
	 * @param command
	 */
	void addCommand(Command command);
	
	/**
	 * This method is used to get command
	 * @param name
	 * @return command
	 */
	Command getCommand(String name);
	
	/**
	 * This method is used to get command list
	 * @return commandList
	 */
	List<Command> getCommands();
}

