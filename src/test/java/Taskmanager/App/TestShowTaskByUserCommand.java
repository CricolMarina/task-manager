package Taskmanager.App;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.stefanini.taskmanager.command.impl.ShowTaskByUserCommand;
import com.stefanini.taskmanager.service.TasksService;

@RunWith(MockitoJUnitRunner.class)
public class TestShowTaskByUserCommand {
	
	@InjectMocks
	private ShowTaskByUserCommand showTaskByUserCommand = new ShowTaskByUserCommand();
	@Mock
	TasksService taskService;

	@Test
	public void testShowTaskByUser_ExecuteCommand_Success() {
		String username = "username";
		String [] args = new String [] {"-showTasks","username"};
		showTaskByUserCommand.execute(args);
		Mockito.verify(taskService).showTaskByUser(username);
	}
}
