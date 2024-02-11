package Company.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Company.Entity.Client;
import Company.Entity.Company;
import Company.Entity.User;
import Company.Repository.ClientRepository;
import Company.Repository.CompanyRepository;
import Company.Repository.UserRepository;

@Component("uniqueDataInitializerName")
public class DataInitializer implements CommandLineRunner {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public DataInitializer(CompanyRepository companyRepository, UserRepository userRepository, ClientRepository clientRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) {
        if (companyRepository.count() == 0 && userRepository.count() == 0 && clientRepository.count() == 0) {
            Company company = new Company("SMS_MAGIC", "Technology");
            companyRepository.save(company);

            User existingUser = userRepository.findByUsername("kedar");

            if (existingUser == null) {
                User user = new User("kedar", "KK2002", company);
                userRepository.save(user);
            }

            Client existingClient = clientRepository.findByName("SMS_MAGIC");

            if (existingClient == null) {
                Client client = new Client("SMS_MAGIC", null, company, null, null);
                clientRepository.save(client);
            }
        }
    }
}
