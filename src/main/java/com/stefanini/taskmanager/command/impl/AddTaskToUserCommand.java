package com.stefanini.taskmanager.command.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.CommandExecutor;
import com.stefanini.taskmanager.command.utils.StringUtil;
import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.service.TasksService;
import com.stefanini.taskmanager.service.UserService;

public class AddTaskToUserCommand extends AbstractCommand implements Command {
	
	private static final Logger logger = LogManager.getLogger(AddTaskToUserCommand.class);
	private static AddTaskToUserCommand addTaskToUserCommand;
	private UserService userService ;
	private TasksService taskService;

	private AddTaskToUserCommand(UserService userService, TasksService taskService) {
		super("addTaskToUser");
		this.userService = userService;
		this.taskService = taskService;
	}
	
	public static AddTaskToUserCommand getInstance(UserService userService, TasksService taskService) {
		if (addTaskToUserCommand == null) {
			addTaskToUserCommand = new AddTaskToUserCommand(userService, taskService);
		}
		return addTaskToUserCommand;
	}

	/**
	 * This method is used to execute addTaskToUser command
	 */
	public void execute(String[] args) {
		logger.info("Executing addTaskToUser command ");
		String firstName = StringUtil.getSubtringByString(args[1]);
		String lastName = StringUtil.getSubtringByString(args[2]);
		String userName = StringUtil.getSubtringByString(args[3]);
		User user = new User(firstName, lastName , userName);
		userService.createUser(user);

		if (user.getId() != null) {
			String taskTitle = StringUtil.getSubtringByString(args[4]);
			String taskDescription = StringUtil.getSubtringByString(args[5]);
			Task task = new Task (userName, taskTitle, taskDescription);
			
			task.setUser(user);
			taskService.addTask(task);
		} 
		else {
			logger.info("No task for this user was added ");
		}
		logger.info(" AddTaskToUser command executed");
	}
	
	/**
	 * This method is used to get args for addTask command
	 * @return args
	 */
	public String[] getArgs() {
		return getArgs();
	}
}


