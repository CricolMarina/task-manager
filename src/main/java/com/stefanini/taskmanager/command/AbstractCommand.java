package com.stefanini.taskmanager.command;

public abstract class AbstractCommand {
	
	private final String NAME;
	
	public AbstractCommand(String name) {
		NAME=name;
	}

	public String getName() {
		return NAME;
	}
}
