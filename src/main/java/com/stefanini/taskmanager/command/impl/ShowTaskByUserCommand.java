package com.stefanini.taskmanager.command.impl;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.utils.StringUtil;
import com.stefanini.taskmanager.service.TasksService;

public class ShowTaskByUserCommand extends AbstractCommand implements Command{
	
	private static final Logger logger = LogManager.getLogger(ShowTaskByUserCommand.class);
	private static ShowTaskByUserCommand showTaskByUserCommand;
	@Autowired
	private TasksService taskService;
	
	public ShowTaskByUserCommand() {
		super("showTasks");
	}
	
	private ShowTaskByUserCommand(TasksService taskService) {
		this();
		this.taskService=taskService;
	}
	
	public static ShowTaskByUserCommand getInstance(TasksService taskService) {
		if (showTaskByUserCommand == null) {
			showTaskByUserCommand = new ShowTaskByUserCommand(taskService);
		}
		return showTaskByUserCommand;
	}
	
	/**
	 * This method is used to execute showTaskByUser command
	 */
	public void execute(String[] args) {
		logger.info("Executing showTaskByUser command ");
		String userName = StringUtil.getSubtringByString(args[1]);
		taskService.showTaskByUser(userName);
		logger.info("ShowTaskByUser command executed");
	}
	
	/**
	 * This method is used to get args for showTaskByUser command
	 * @return args
	 */
	public String[] getArgs() {
    	System.out.println("Introduce username :" );
    	Scanner scanner = new Scanner(System.in);
    	String userName = scanner.nextLine();
    	String [] args = new String[2];
    	args[0] = "-showTasks";
    	args[1] = userName;
    	return args;
    }
}
