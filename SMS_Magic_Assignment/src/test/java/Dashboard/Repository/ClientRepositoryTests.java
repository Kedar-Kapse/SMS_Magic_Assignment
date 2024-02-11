package Dashboard.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import Company.Entity.Client;
import Company.Entity.Company;
import Company.Entity.User;
import Company.Repository.ClientRepository;
import Company.Repository.CompanyRepository;
import Company.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ClientRepositoryTests {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        Company company = companyRepository.save(new Company("ABC Ltd", "Technology"));
        User user = userRepository.save(new User("john_doe", "password123", company));

        Client client = clientRepository.save(new Client("John Doe", user, company, "john.doe@example.com", "123456789"));

        Optional<Client> foundClientOptional = clientRepository.findByEmail("john.doe@example.com");

        assertTrue(foundClientOptional.isPresent(), "Client not found");
        Client foundClient = foundClientOptional.get();
        assertEquals("John Doe", foundClient.getName());
        assertEquals("john.doe@example.com", foundClient.getEmail());
    }

    @Test
    public void testFindByCompany() {
        // Your test logic here...
        Company company = companyRepository.save(new Company("XYZ Ltd", "Finance"));
        User user = userRepository.save(new User("password123", "user1", company));

        Client client1 = clientRepository.save(new Client("Client 1", user, company, "client1@example.com", "987654321"));
        Client client2 = clientRepository.save(new Client("Client 2", user, company, "client2@example.com", "654321987"));

        List<Client> foundClients = clientRepository.findByCompany(company);

        assertEquals(2, foundClients.size());
        assertTrue(foundClients.contains(client1));
        assertTrue(foundClients.contains(client2));
    }
}