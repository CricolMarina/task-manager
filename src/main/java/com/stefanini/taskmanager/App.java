package com.stefanini.taskmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.CommandInvoker;
import com.stefanini.taskmanager.command.impl.AddTaskCommand;
import com.stefanini.taskmanager.command.impl.CommandInvokerImpl;
import com.stefanini.taskmanager.command.impl.CreateUserCommand;
import com.stefanini.taskmanager.command.impl.ShowAllUsersCommand;
import com.stefanini.taskmanager.command.impl.ShowTaskByUserCommand;
import com.stefanini.taskmanager.dao.factory.AbstractFactoryTask;
import com.stefanini.taskmanager.dao.factory.AbstractFactoryUser;
import com.stefanini.taskmanager.dao.factory.impl.TaskDAOFactoryHibernate;
import com.stefanini.taskmanager.dao.factory.impl.UserDAOFactoryHibernate;
import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.service.TasksService;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.TasksServiceImpl;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

public class App {
	
	private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ){
        
    	logger.info("Starting application");
    	
    	AbstractFactoryUser daoFactory = new UserDAOFactoryHibernate();
    	UserService userService = new UserServiceImpl(daoFactory);
    	
    	AbstractFactoryTask daoFactory1 = new TaskDAOFactoryHibernate();
    	TasksService taskService = new TasksServiceImpl(daoFactory1);

    	CommandInvoker commandInvoker = CommandInvokerImpl.getInstance();
    	commandInvoker.addCommand(CreateUserCommand.getInstance(userService));
    	commandInvoker.addCommand(AddTaskCommand.getInstance(taskService));
    	commandInvoker.addCommand(ShowAllUsersCommand.getInstance(userService));
    	commandInvoker.addCommand(ShowTaskByUserCommand.getInstance(taskService));
    	
    	commandInvoker.execute(args);
    	logger.info("Ending application");

    }
}
