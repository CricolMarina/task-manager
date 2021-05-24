package com.stefanini.taskmanager.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.CommandInvoker;

public class CommandInvokerImpl implements CommandInvoker{
	
	private static final Logger logger = LogManager.getLogger(CommandInvokerImpl.class);
	private final String NAME = "CommandInvoker"; 
	private static CommandInvokerImpl commandInvoker;
	private List<Command> commandList = new ArrayList<Command>();
	
	private CommandInvokerImpl() {}
	
	public static CommandInvokerImpl getInstance() {
		if(commandInvoker == null) {
			commandInvoker = new CommandInvokerImpl();
		}
		return commandInvoker;
	}
	
	public String getName(){
		return NAME;
	}
	
	/**
	 * This method is used to add a command
	 * @param command
	 */
	public void addCommand(Command command) {
		commandList.add(command);
	}
	
	/**
	 * This method is used to execute a command
	 */
	public void execute(String [] args) {
		boolean hasFound=false;
		if(args.length==0) {
			logger.info("Error! No command to execute!");
	        return;
		}
		for (Command cmd : commandList) {
			String commandName = args[0].substring(1);
			if (cmd.getName().equals(commandName)) {
				hasFound=true;
				cmd.execute(args);
				continue;
			} 
		}
		 	if (!hasFound) {
		 		logger.info("Error! Wrong command ! ");
		}
	}
}	

