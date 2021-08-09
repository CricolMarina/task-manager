package com.stefanini.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.stefanini.taskmanager.command.CommandInvoker;
import com.stefanini.taskmanager.command.args.CommandCollection;

@SpringBootApplication
public class AppSpring extends CommandCollection{
	
	@Autowired private CommandInvoker commandInvoker;
	private static String[] arguments;
	
	public static void main(String[] args) {
		arguments = args;
    	SpringApplication.run(AppSpring.class, args);
    }
	
	@Bean
	public void executeApp() {
		if (arguments.length>0) {
			commandInvoker.execute(arguments);
		} else {
			CommandCollection commandCollection = new CommandCollection();
			commandCollection.execute(commandInvoker); 
			}
		System.out.println("Ending application");
	}
}
