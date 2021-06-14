package com.stefanini.taskmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public static void main( String[] args ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    	logger.info("Starting application");
    	AbstractFactoryUser user = new UserDAOFactoryHibernate();
    	UserService userService = new UserServiceImpl(user);
    	
    	AbstractFactoryTask task = new TaskDAOFactoryHibernate();
    	TasksService taskService = new TasksServiceImpl(task);

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
    	//invoke execute method for commandInvoker
    	commandInvoker.execute(args);
    	logger.info("Ending application");
    	}
    }
