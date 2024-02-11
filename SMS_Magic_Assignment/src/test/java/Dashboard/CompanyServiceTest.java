package Dashboard;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import Company.Entity.Company;
import Company.Repository.CompanyRepository;
import Company.Service.CompanyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@DataJpaTest
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @MockBean
    private CompanyRepository companyRepository;

    @Test
    public void testGetCompanyById() {
        
        Long companyId = 1L;
        Company mockCompany = new Company("Test Company", "Technology");
        when(companyRepository.findById(companyId)).thenReturn(Optional.of(mockCompany));
 
        Optional<Company> result = companyService.getCompanyById(companyId);

        
        assertTrue(result.isPresent());
        assertEquals(mockCompany, result.get());
    }

    @Test
    public void testGetAllCompanies() {
       
        List<Company> mockCompanies = List.of(
                new Company("Company A", "IT"),
                new Company("Company B", "Finance"),
                new Company("Company C", "Healthcare")
        );
        when(companyRepository.findAll()).thenReturn(mockCompanies);

        
        List<Company> result = companyService.listCompanies();

       
        assertEquals(mockCompanies.size(), result.size());
        assertTrue(result.containsAll(mockCompanies));
    }

    @Test
    public void testSaveCompany() {
       
        Company companyToSave = new Company("New Company", "Logistics");
        Company savedCompany = new Company("New Company", "Logistics"); 
        when(companyRepository.save(companyToSave)).thenReturn(savedCompany);

       
        Company result = companyService.saveCompany(companyToSave);

        
        assertEquals(savedCompany, result);
        verify(companyRepository, times(1)).save(companyToSave);
    }

   

}
