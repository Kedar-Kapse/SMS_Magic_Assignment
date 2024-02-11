package Company.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Company.Entity.User;
import Company.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
       
        userRepository.save(user);
    }

    public void updateUserField(Long userId, String fieldName, String newValue) {
       
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

      
        switch (fieldName) {
            case "username":
                user.setUsername(newValue);
                break;
            case "password":
                user.setPassword(newValue);
                break;
            
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }

       
        userRepository.save(user);
    }


    public List<User> listUsers() {
      
        return userRepository.findAll();
    }

   
}
