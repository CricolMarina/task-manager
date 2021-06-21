package com.stefanini.taskmanager.command;

public class CommandExecutor implements Runnable{
	
	private CommandInvoker commandInvoker;
	private String[] params;
	
	public CommandExecutor(CommandInvoker commandInvoker) {
		this.commandInvoker = commandInvoker;
	}
	
	public void executeCommand(String[] params) {
		this.params = params;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		System.out.println("Executing command " + params[0]);
		commandInvoker.execute(params);
	}
}
