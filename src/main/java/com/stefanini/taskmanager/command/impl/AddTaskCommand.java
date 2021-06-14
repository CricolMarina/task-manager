package com.stefanini.taskmanager.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.utils.StringUtil;
import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.service.TasksService;
import com.stefanini.taskmanager.service.UserService;

public class AddTaskCommand extends AbstractCommand implements Command{
	
	private static final Logger logger = LogManager.getLogger(AddTaskCommand.class);
	private static AddTaskCommand addTaskCommand;
	private TasksService taskService ;
	private UserService userService;

	private AddTaskCommand(TasksService taskService, UserService userService) {
		super("addTask");
		this.taskService = taskService;
		this.userService = userService;
	}
	
	public static AddTaskCommand getInstance(TasksService taskService, UserService userService) {
		if (addTaskCommand == null) {
			addTaskCommand = new AddTaskCommand(taskService, userService);
		}
		return addTaskCommand;
	}
	
	/**
	 * This method is used to execute addTask command
	 */
	public void execute(String[] args) {
		logger.info("Executing addTask command ");
		String userName = StringUtil.getSubtringByString(args[1]);
		String taskTitle = StringUtil.getSubtringByString(args [2]);
		String taskDescription = StringUtil.getSubtringByString(args[3]);
		//create task object with the specified parameters
		Task task = new Task( userName, taskTitle,  taskDescription );
		
		try {
			User user = userService.getUserByUsername(userName);
			if (user != null) {
				task.setUser(user);
				//add task to the task list
				taskService.addTask(task);
				logger.info("New task added for user " + user.getUsername());
				} 
			} catch (NullPointerException e) {
				logger.info("No user with this username!");
			}
		}
	}