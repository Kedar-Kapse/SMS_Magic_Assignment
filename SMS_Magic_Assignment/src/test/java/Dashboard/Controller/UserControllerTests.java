package Dashboard.Controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import Company.Controller.UsersController;
import Company.Entity.User;
import Company.Service.UserService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UsersController userController;

    @Test
    void testListUsers() {
       
    	
        User user1 = new User("KEDAR", "password", null);
        User user2 = new User("RAM", "secure_password", null);

        
        List<User> mockUsers = Arrays.asList(user1, user2);

        when(userService.listUsers()).thenReturn(mockUsers);

      
        List<User> result = userController.listUsers();

        
        assertEquals(mockUsers, result);
    }

}
