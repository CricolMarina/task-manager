package Taskmanager.App;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.stefanini.taskmanager.command.impl.ShowAllUsersCommand;
import com.stefanini.taskmanager.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestShowAllUsersCommand {
	
	@InjectMocks
	ShowAllUsersCommand showAllUsersCommand;
	
	@Mock
	UserService userService;
	
	@Before
	public void initTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShowAllUsers_ExecuteCommand_Success() {
		String[] args = new String[] {"-showAllUsers"};
		showAllUsersCommand.execute(args);
		verify(userService).showAllUsers();
	}
	

}
