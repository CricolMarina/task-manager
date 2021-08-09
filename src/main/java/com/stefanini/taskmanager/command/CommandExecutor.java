package com.stefanini.taskmanager.command;

public class CommandExecutor extends Thread {
	private CommandInvoker commandInvoker;
	private String[] params;
	private Thread depedendThread;
	
	public CommandExecutor(CommandInvoker commandInvoker, String[] params) {
		this.commandInvoker = commandInvoker;
		this.params = params;
	}
	
	public String[] getParams() {
		return params;
	}
	
	public void executeCommand() {
		start();
	}
	
	/**
	 * This method is used to execute command
	 * @param dependentThread
	 */
	public void executeCommand(Thread dependentThread) {
		this.depedendThread = dependentThread;
		executeCommand();
	}
	/**
	 * This method is used to run command
	 */
	public void run() {
		try {
			if(depedendThread!=null) {
				depedendThread.join();
			} 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executing command " + params[0]);
		commandInvoker.execute(params);
	}

}
