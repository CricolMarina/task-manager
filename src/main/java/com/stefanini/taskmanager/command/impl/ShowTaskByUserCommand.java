package com.stefanini.taskmanager.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.utils.StringUtil;
import com.stefanini.taskmanager.service.TasksService;

public class ShowTaskByUserCommand extends AbstractCommand implements Command{
	
	private static final Logger logger = LogManager.getLogger(ShowTaskByUserCommand.class);
	private static ShowTaskByUserCommand showTaskByUserCommand;
	private TasksService taskService;
	
	private ShowTaskByUserCommand(TasksService taskService) {
		super("showTasks");
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
	}
