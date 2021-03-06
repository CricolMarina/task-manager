package com.stefanini.taskmanager.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.CommandInvoker;

public class CommandInvokerImpl implements CommandInvoker{
	
	private static final Logger logger = LogManager.getLogger(CommandInvokerImpl.class);
	private final String NAME = "CommandInvoker"; 
	private static CommandInvokerImpl commandInvoker;
	
	@Autowired private List<Command> commandList = new ArrayList<Command>();
	
	public CommandInvokerImpl() {}
	
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
	
	public List<Command> getCommands() {
		return commandList;
	}
	
	public Command getCommand(String name){
		for (Command cmd : commandList) {
			if (cmd.getName().equals(name)) {
				return cmd;
			}
		} 
		return null;
	}
	/**
	 * This method is used to execute a command
	 */
	public void execute(String [] args) {
		//set false value for hasFound variable
		boolean hasFound=false;
		//check if there is a command to execute
		if(args.length==0) {
			logger.info("Error! No command to execute!");
	        return;
		}
		//find command in the commandList
		for (Command cmd : commandList) {
			String commandName = args[0].substring(1);
			//check if the name of command has been found in command list
			if (cmd.getName().equals(commandName)) {
				hasFound=true;
				cmd.execute(args);
				continue;
			} 
		}
		//return error message if command has not been found in command list
		 	if (!hasFound) {
		 		logger.info("Error! Wrong command ! ");
		 	}
	}
	
	public String[] getArgs() {
		return null;
	}
}	

