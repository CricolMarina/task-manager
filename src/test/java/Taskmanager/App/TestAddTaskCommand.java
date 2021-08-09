package Taskmanager.App;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.stefanini.taskmanager.command.impl.AddTaskCommand;
import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.service.TasksService;
import com.stefanini.taskmanager.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestAddTaskCommand {
	
	@InjectMocks
	AddTaskCommand addTaskCommand = new AddTaskCommand();
	
	@Mock
	TasksService tasksService ;
	@Mock
	UserService userService;
	
	@Before
	public void initTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddTask_ExecuteCommand_Success() {
		User user = new User("FirstName", "LastName", "username");
		Task task = new Task("username","task_title", "task_description");
		Mockito.when(userService.getUserByUsername(user.getUsername())).thenReturn(user);
		Mockito.when(tasksService.addTask(any(Task.class))).thenReturn(task);
		String [] args = new String[] {"-addTask","username","task_title", "task_description"};
		addTaskCommand.execute(args);
		Mockito.verify(tasksService).addTask(any(Task.class));
	}
}
