package com.stefanini.taskmanager.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.utils.StringUtil;
import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.service.TasksService;

public class AddTaskCommand extends AbstractCommand implements Command{
	
	private static final Logger logger = LogManager.getLogger(AddTaskCommand.class);
	private static AddTaskCommand addTaskCommand;
	private TasksService taskService ;

	private AddTaskCommand(TasksService taskService) {
		super("addTask");
		this.taskService = taskService;
	}
	
	public static AddTaskCommand getInstance(TasksService taskService) {
		if (addTaskCommand == null) {
			addTaskCommand = new AddTaskCommand(taskService);
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
		Task task = new Task( userName, taskTitle,  taskDescription );
		User user = new User();
		user.setUsername(userName);
		task.setUser(user);
		taskService.addTask(task);
		logger.info("New task added ");
	}
	
}
