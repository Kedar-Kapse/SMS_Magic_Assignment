package Dashboard.Service;



import Company.Entity.User;
import Company.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUserField(Long userId, String field, String value) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            switch (field) {
                case "username":
                    user.setUsername(value);
                    break;
                case "password":
                    user.setPassword(value);  // You might want to hash the password in a real application
                    break;
                // Add more cases for other fields if needed
                default:
                    throw new IllegalArgumentException("Invalid field: " + field);
            }

            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }

    // Add more service methods as needed
}
