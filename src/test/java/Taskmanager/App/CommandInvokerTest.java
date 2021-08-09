package Taskmanager.App;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.CommandInvoker;
import com.stefanini.taskmanager.command.impl.CommandInvokerImpl;

public class CommandInvokerTest {
	
	private CommandInvoker commandInvoker;
	
	@Before
	public void initTest() {
		commandInvoker = new CommandInvokerImpl();
	}
	
	@Test
	public void testCommandInvoker_GetCommand_Ok() {
		Command addTask = Mockito.mock(Command.class);
		Command createUser = Mockito.mock(Command.class);

		Mockito.when(addTask.getName()).thenReturn("addTask");
		Mockito.when(createUser.getName()).thenReturn("createUser");
		
		commandInvoker.addCommand(addTask);
		commandInvoker.addCommand(createUser);

		Command expectedCommand =  commandInvoker.getCommand("addTask");

		assertEquals(addTask, expectedCommand);
		Mockito.verify(addTask).getName();
	}
	
	
	@Test
	public void testCommandInvoker_GetCommand_Null () {
		assertNull(commandInvoker.getCommand("adTask"));
	}
	
	@Test
	public void testCommandInvoker_ExecuteCommand() {
		Command addTask = Mockito.mock(Command.class);
		Command createUser = Mockito.mock(Command.class);
		Command showAllUsers = Mockito.mock(Command.class);
		
		Mockito.when(addTask.getName()).thenReturn("addTask");
		Mockito.when(createUser.getName()).thenReturn("createUser");
		Mockito.when(showAllUsers.getName()).thenReturn("showAllUsers");
		
		commandInvoker.addCommand(addTask);
		commandInvoker.addCommand(createUser);
		commandInvoker.addCommand(showAllUsers);
		
		String[] args = new String[] {"-createUser", "Marina", "Cricol", "mina"};
		commandInvoker.execute(args);
		
		Mockito.verify(createUser).execute(args);
	}
	
	@Test
	public void testCommandInvoker_getCommands() {
		
		Command createUser = Mockito.mock(Command.class);
		Command addTask = Mockito.mock(Command.class);
		
		commandInvoker.addCommand(createUser);
		commandInvoker.addCommand(addTask);
		
		List<Command> commandList = commandInvoker.getCommands();
		
		assertEquals( 2, commandList.size());
		
	}
}
