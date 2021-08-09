package com.stefanini.taskmanager.command.args;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.taskmanager.command.CommandExecutor;
import com.stefanini.taskmanager.command.CommandInvoker;

public class CommandCollection extends CommandArgsList{
	
	public void execute(CommandInvoker commandInvoker) {
		CommandArgsList commandArgs = new CommandArgsList();
		List<CommandExecutor> commandExecutorList = new ArrayList<CommandExecutor>();
			
		for(String[] arguments : commandArgs.getArgsList(commandInvoker)) {
	    	commandExecutorList.add(new CommandExecutor(commandInvoker, arguments));
		}
		
		for(CommandExecutor commandExecutor : commandExecutorList) {
			CommandExecutor dependent = null;
			if ("showAllUsers".equals(getCommandName(commandExecutor))){
				dependent = getDependentForShowAllUsersComm(commandExecutorList);
			} else if ("showTasks".equals(getCommandName(commandExecutor))) {
				dependent = getDependentForShowTasksComm(commandExecutorList, commandExecutor);
			} else if ("addTask".equals(getCommandName(commandExecutor))) {
				dependent=getDependentForAddTaskComm(commandExecutorList, commandExecutor);
			}
			commandExecutor.executeCommand(dependent);
		} 
	}
	/**
	 * This method is used to get dependent for showAllUsers command    	
	 * @param commandExecutorList
	 * @return dependent
	 */
	public CommandExecutor getDependentForShowAllUsersComm(List<CommandExecutor> commandExecutorList) {
		CommandExecutor dependent = null;
		for(CommandExecutor commandEx: commandExecutorList) {
			    if(("addTask").equals(getCommandName(commandEx))) {
			    	dependent = commandEx;
			    	break;
		   	} else if("createUser".equals(getCommandName(commandEx))){
		   		dependent = commandEx;
		   	} 
		}
		return dependent;
	}
	
	/**
     * This method is used to get dependent for showTasks command
     * @param commandExecutorList
     * @param commandExecutor
     * @return dependent
     */
	public CommandExecutor getDependentForShowTasksComm(List<CommandExecutor> commandExecutorList, CommandExecutor commandExecutor) {
		CommandExecutor dependent = null;
		for(CommandExecutor commandEx: commandExecutorList) {
			if("addTask".equals(getCommandName(commandEx))) {
		    	if(commandExecutor.getParams()[1].equals(commandEx.getParams()[1])) {
		    		dependent = commandEx;
		    			}
				} else if("createUser".equals(getCommandName(commandEx))
					&& commandExecutor.getParams()[1].equals(commandEx.getParams()[3])) {
		    		dependent = commandEx;
			    }
		} 
		return dependent; 
	} 
	
	/**
     * This method is used to get dependent for addTask command
     * @param commandExecutorList
     * @param commandExecutor
     * @return dependent
     */
	public CommandExecutor getDependentForAddTaskComm(List<CommandExecutor> commandExecutorList, CommandExecutor commandExecutor) {
		CommandExecutor dependent = null;
			for(CommandExecutor commandEx: commandExecutorList) {
				if("createUser".equals(getCommandName(commandEx))
					&& commandExecutor.getParams()[1].equals(commandEx.getParams()[3])) {
						dependent = commandEx;
				}
			}
		return dependent; 
	}

	/**
	 * This method is used to get command name
	 * @param commandExecutor
	 * @return commandName
	 */
	public String getCommandName(CommandExecutor commandExecutor) {
		String commandName = commandExecutor.getParams()[0].substring(1);
		return commandName;
	}
}
