package com.stefanini.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.CommandExecutor;
import com.stefanini.taskmanager.command.CommandInvoker;
import com.stefanini.taskmanager.command.impl.AddTaskCommand;
import com.stefanini.taskmanager.command.impl.AddTaskToUserCommand;
import com.stefanini.taskmanager.command.impl.CommandInvokerImpl;
import com.stefanini.taskmanager.command.impl.CreateUserCommand;
import com.stefanini.taskmanager.command.impl.ShowAllUsersCommand;
import com.stefanini.taskmanager.command.impl.ShowTaskByUserCommand;
import com.stefanini.taskmanager.dao.factory.AbstractFactoryTask;
import com.stefanini.taskmanager.dao.factory.AbstractFactoryUser;
import com.stefanini.taskmanager.dao.factory.impl.TaskDAOFactoryHibernate;
import com.stefanini.taskmanager.dao.factory.impl.UserDAOFactoryHibernate;
import com.stefanini.taskmanager.service.TasksService;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.TasksServiceImpl;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) throws NoSuchFieldException, SecurityException, 
    IllegalArgumentException, IllegalAccessException{
    	logger.info("Starting application");
    	AbstractFactoryUser userFactory = new UserDAOFactoryHibernate();
    	UserService userService = new UserServiceImpl(userFactory);
    	
    	AbstractFactoryTask taskFactory = new TaskDAOFactoryHibernate();
    	TasksService taskService = new TasksServiceImpl(taskFactory);

    	//create commandInvoker object 
    	CommandInvoker commandInvoker = CommandInvokerImpl.getInstance();
    	//add createUser command to command list
    	commandInvoker.addCommand(CreateUserCommand.getInstance(userService));
    	//add addTask command to command list
    	commandInvoker.addCommand(AddTaskCommand.getInstance(taskService,userService));
    	//add showAllUsers command to command list 
    	commandInvoker.addCommand(ShowAllUsersCommand.getInstance(userService));
    	//add showTaskByUser command to command list
    	commandInvoker.addCommand(ShowTaskByUserCommand.getInstance(taskService));
    	
    	commandInvoker.addCommand(AddTaskToUserCommand.getInstance(userService, taskService));
    
    	if(args.length > 0 ) {
        	//invoke execute method for commandInvoker
        	commandInvoker.execute(args);
        	
    	} else {
    		String choice = "y";
    	    List<String[]> argsList = new ArrayList<String[]>();
    	    while ("y".equals(choice)) {
    			String[] commandArgs = null;
		    	System.out.println("List of commands :" + '\n' + 
	    				"1. Create user command" + '\n' + 
	    				"2. Add task command" + '\n' + 
	    				"3. Show all users command" + '\n' + 
	    				"4. Show task by username command" + '\n' );
	    		System.out.println("Please select command to execute :");
	    		Scanner scan  = new Scanner(System.in);
	    		int commandNo = scan.nextInt();
	    		if (commandNo < 5) {
	    			commandArgs = commandInvoker.getCommands().get(commandNo-1).getArgs();
    			} else {    				
	    			System.out.println("No command to execute!");
	    		}
	    		if(commandArgs !=  null) {
	    			argsList.add(commandArgs);
	    		}
		    	System.out.println("\nPress \"y\" to execute a command or something else to end application ");
		    	Scanner scanner  = new Scanner(System.in);
		    	choice = scanner.nextLine();
	    	}
    	    
    	    for (String[] arguments : argsList) {
    	    	CommandExecutor commandExecutor = new CommandExecutor(commandInvoker);
    			commandExecutor.executeCommand(arguments);
    		}
    	} 
	    System.out.println("Ending application");
    }
}
