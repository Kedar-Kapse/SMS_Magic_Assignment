package Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Company.Entity.Company;
import Company.Entity.User;
import Company.Repository.CompanyRepository;
import Company.Repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Autowired
    public DataInitializer(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (companyRepository.count() == 0 && userRepository.count() == 0) {
            Company company = new Company("Example Company", "Technology");
            companyRepository.save(company);

            String adminUsername = "Kedar";
            User existingUser = userRepository.findByUsername(adminUsername);

            if (existingUser == null) {
                User adminUser = new User(adminUsername, "KK2002", company);
                userRepository.save(adminUser);
            }
        }
    }
}
