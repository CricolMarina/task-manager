package Taskmanager.App;
import static org.mockito.ArgumentMatchers.any;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.stefanini.taskmanager.command.impl.CreateUserCommand;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestCreateUserCommand {
	@InjectMocks
	private CreateUserCommand createUserCommand = new CreateUserCommand();
	@Mock
	private UserService userService;
	
	@Before
	public void initTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateUser_ExecuteCommand_SuccessExecution() throws SQLIntegrityConstraintViolationException {
		User user = new User("FirstName", "LastName", "username");
		Mockito.when(userService.createUser(any(User.class))).thenReturn(user);
		String[] args = new String[] {"-createUser", "FirstName", "LastName", "username"};
		createUserCommand.execute(args);
		Mockito.verify(userService).createUser(any(User.class));
	}
}
