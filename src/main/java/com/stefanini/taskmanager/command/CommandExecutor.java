package com.stefanini.taskmanager.command;

public class CommandExecutor extends Thread {
	
	private CommandInvoker commandInvoker;
	private String[] params;
	private Thread depedendThread;
	
	public CommandExecutor(CommandInvoker commandInvoker) {
		this.commandInvoker = commandInvoker;
	}
	
	public void executeCommand(String[] params) {
		this.params = params;
		start();
	}
	
	public void executeCommand(String[] params, Thread dependentThread) {
		this.depedendThread = dependentThread;
		executeCommand(params);
	}
	
	public void run() {
		System.out.println("Executing command " + params[0]);
		try {
			depedendThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commandInvoker.execute(params);
	}
}
