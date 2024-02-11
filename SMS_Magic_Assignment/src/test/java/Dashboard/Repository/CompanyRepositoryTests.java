package Dashboard.Repository;



import Company.Entity.Company;
import Company.Repository.CompanyRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CompanyRepositoryTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testFindByName() {
        // Create a Company and save it to the database
        Company company = new Company("ABC Ltd", "Technology");
        companyRepository.save(company);

        // Retrieve the Company by name using the repository method
        Company foundCompany = companyRepository.findByName("ABC Ltd");

        // Verify that the retrieved Company matches the expected Company
        assertEquals("ABC Ltd", foundCompany.getName());
        assertEquals("Technology", foundCompany.getIndustry());
    }

    // Add more test methods as needed for other repository methods

}
