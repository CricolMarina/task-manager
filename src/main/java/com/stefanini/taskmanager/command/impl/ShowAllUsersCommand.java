package com.stefanini.taskmanager.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.service.UserService;

public class ShowAllUsersCommand extends AbstractCommand implements Command{
	
	private static final Logger logger = LogManager.getLogger(ShowAllUsersCommand.class);
	private static ShowAllUsersCommand showAllUsersCommand;
	@Autowired
	private UserService userService;
	
	public ShowAllUsersCommand() {
		super("showAllUsers");
	}
	
	private ShowAllUsersCommand(UserService userService) {
		this();
		this.userService=userService;
	}
	
	public static ShowAllUsersCommand getInstance(UserService userService) {
		if(showAllUsersCommand == null) {
			showAllUsersCommand = new ShowAllUsersCommand(userService);
		}
		return showAllUsersCommand;
	}
	
	/**
	 * This method is used to execute showAllUsers command
	 */
	public void execute(String[] args) {
		logger.info("Execute showAllUsers command ");
		userService.showAllUsers();
		logger.info("ShowAllUsers command executed");
	}
	
	/**
	 * This method is used to get args for showAllUsers command
	 * @return args
	 */
	public  String[] getArgs() {
    	String[]args = new String[1];
    	args[0] = "-showAllUsers";
    	return args;
    }
}
