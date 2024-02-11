package Company.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Company.Entity.Client;
import Company.Entity.ClientUsers;
import Company.Entity.User;
import Company.Repository.ClientUsersRepository;

import java.util.List;

@Service
public class ClientUsersService {

    @Autowired
    private ClientUsersRepository clientUsersRepository;

    private static final Logger logger = LoggerFactory.getLogger(ClientUsersService.class);

    public void saveClientUsers(ClientUsers clientUsers) {
        clientUsersRepository.save(clientUsers);
    }

    public List<ClientUsers> getClientUsersByClient(Client client) {
        return clientUsersRepository.findByClient(client);
    }

    public List<ClientUsers> getClientUsersByUser(User user) {
        return clientUsersRepository.findByUser(user);
    }

    public List<ClientUsers> getAllActiveClientUsers() {
        return clientUsersRepository.findByActiveTrue();
    }

    public List<ClientUsers> getAllDeletedClientUsers() {
        return clientUsersRepository.findByDeletedAtIsNotNull();
    }

    // You can add more methods as needed for your application logic

    // Example method for business logic involving ClientUsers
    public void performSomeBusinessLogic(ClientUsers clientUsers) {
        // Example business logic: Log information about the clientUsers
        logger.info("Performing business logic for ClientUsers:");
        logger.info("ClientUsers ID: {}", clientUsers.getId());
        logger.info("ClientUsers Client: {}", clientUsers.getClient().getName());
        logger.info("ClientUsers User: {}", clientUsers.getUser().getUsername());
        logger.info("ClientUsers Created At: {}", clientUsers.getCreatedAt());
        logger.info("ClientUsers Updated At: {}", clientUsers.getUpdatedAt());
        
        // Your additional business logic here
    }
}
