package com.stefanini.taskmanager.command.args;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.stefanini.taskmanager.command.CommandInvoker;

public class CommandArgsList {
	
	public List<String[]> getArgsList(CommandInvoker commandInvoker) {
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
	    return argsList;
	}
}
