package Dashboard.Service;

import Company.Entity.Company;
import Company.Repository.CompanyRepository;
import Company.Service.CompanyService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CompanyServiceTests {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    @Test
    public void testUpdateCompanyField() {
        // Create an existing Company
        Company existingCompany = new Company();
        existingCompany.setId(1L);
        existingCompany.setName("ABC Ltd");
        existingCompany.setIndustry("Technology");

        // Mock the behavior of CompanyRepository.findById
        when(companyRepository.findById(1L)).thenReturn(Optional.of(existingCompany));

        // Test the updateCompanyField method
        companyService.updateCompanyField(1L, "name", "New Name");

        // Verify that the Company's name has been updated
        assertEquals("New Name", existingCompany.getName());
    }

    // Add more test methods as needed for other service methods

}
