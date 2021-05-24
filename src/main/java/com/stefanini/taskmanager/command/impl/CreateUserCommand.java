package com.stefanini.taskmanager.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.utils.StringUtil;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.service.UserService;

public class CreateUserCommand extends AbstractCommand implements Command {
	
	private static final Logger logger = LogManager.getLogger(CreateUserCommand.class);
	private static CreateUserCommand createUserCommand;
	private UserService userService;
	
	private CreateUserCommand(UserService userService) {
		super("createUser");
		this.userService=userService;
	}
	
	public static CreateUserCommand getInstance(UserService userService) {
		if(createUserCommand == null) {
			createUserCommand = new CreateUserCommand(userService);
		}
		return createUserCommand;
	}
	
	/**
	 * This method is used to execute createUser command
	 */
	public void execute(String[] args) {
		logger.info("Executing createUser command ");
		String userName = StringUtil.getSubtringByString(args[1]);
		String firstName = StringUtil.getSubtringByString(args[2]);
		String lastName = StringUtil.getSubtringByString(args[3]);
		User user = new User( userName, firstName, lastName );
		userService.createUser(user);
		logger.info("New user created ");
		}
	}

