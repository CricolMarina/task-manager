package com.stefanini.taskmanager.app.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.CommandInvoker;
import com.stefanini.taskmanager.command.impl.AddTaskCommand;
import com.stefanini.taskmanager.command.impl.CommandInvokerImpl;
import com.stefanini.taskmanager.command.impl.CreateUserCommand;
import com.stefanini.taskmanager.command.impl.ShowAllUsersCommand;
import com.stefanini.taskmanager.command.impl.ShowTaskByUserCommand;
import com.stefanini.taskmanager.dao.TasksDAO;
import com.stefanini.taskmanager.dao.UserDAO;
import com.stefanini.taskmanager.dao.hibernate.TaskDAOHibernate;
import com.stefanini.taskmanager.dao.hibernate.UserDAOHibernate;
import com.stefanini.taskmanager.service.TasksService;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.TasksServiceImpl;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

@Configuration
public class AppConfig {
//	@Bean
//	public UserService getUserService() {
//		return new UserServiceImpl();
//	}
	
//	@Bean
//	public UserDAO getUserDAO() {
//		return new UserDAOHibernate();
//	}
	
//	@Bean
//	public TasksService getTaskService() {
//		return new TasksServiceImpl();
//	}
//	
//	@Bean
//	public TasksDAO getTasksDAO() {
//		return new TaskDAOHibernate();
//	}
	
	@Bean
	public CommandInvoker getCommandInvoker() {
		return new CommandInvokerImpl();
	}
	
	@Bean
	public Command getCreateUserCommand() {
		return new CreateUserCommand();
	}
	
	@Bean
	public Command getAddTaskCommand() {
		return new AddTaskCommand();
	}
	
	@Bean
	public Command getShowAllUsersCommand() {
		return new ShowAllUsersCommand();
	}
	
	@Bean
	public Command getShowTaskByUserCommand() {
		return new ShowTaskByUserCommand();
	}
}
