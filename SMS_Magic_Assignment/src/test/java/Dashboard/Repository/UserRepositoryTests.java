package Dashboard.Repository;


import Company.Entity.User;
import Company.Repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        // Create a User and save it to the database
        User user = new User("john_doe", "password123", null);
        userRepository.save(user);

        // Retrieve the User by username using the repository method
        Optional<User> foundUserOptional = Optional.of(userRepository.findByUsername("john_doe"));

        // Verify that the User is present and matches the expected User
        assertTrue(foundUserOptional.isPresent());
        User foundUser = foundUserOptional.get();
        assertEquals("john_doe", foundUser.getUsername());
        assertEquals("password123", foundUser.getPassword());
    }

    // Add more test methods as needed for other repository methods

}
