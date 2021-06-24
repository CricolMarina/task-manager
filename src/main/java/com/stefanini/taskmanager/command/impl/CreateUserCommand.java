package com.stefanini.taskmanager.command.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.AbstractCommand;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.CommandExecutor;
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
		System.out.println("Executing createUser command ");
		String firstName = StringUtil.getSubtringByString(args[1]);
		String lastName = StringUtil.getSubtringByString(args[2]);
		String userName = StringUtil.getSubtringByString(args[3]);
		User user = new User(firstName, lastName, userName);
		if (userService.createUser(user)!= null) { ;
			System.out.println("New user was created");
		}
	}
	
	/**
	 * This method is used to get args for createUser command
	 * @return args
	 */
	public String[] getArgs() {
		System.out.println("Introduce firstName :" );
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.nextLine();
		System.out.println("Introduce lastName : " );
		String lastName = scanner.nextLine();
		System.out.println("Introduce userName : " );
		String username = scanner.nextLine();
		String [] args = new String[4];
		args[0]="-createUser";
		args[1]=firstName; 
		args[2]=lastName;
		args[3]=username;
		return args ;
	}
}
