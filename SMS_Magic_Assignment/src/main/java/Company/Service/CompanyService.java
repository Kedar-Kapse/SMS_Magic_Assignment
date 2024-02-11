package Company.Service;

import Company.Entity.Company;
import Company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void createCompany(Company company) {
        // Business logic for creating a company
        companyRepository.save(company);
    }

    public void updateCompanyField(Long companyId, String fieldName, String newValue) {
        // Business logic for updating a company field
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        // Update the specified field based on fieldName
        switch (fieldName) {
            case "name":
                company.setName(newValue);
                break;
            case "industry":
                company.setIndustry(newValue);
                break;
            // Add other fields as needed
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }

        // Save the updated Company entity
        companyRepository.save(company);
    }

    public List<Company> listCompanies() {
        // Business logic for listing companies
        return companyRepository.findAll();
    }

	public Optional<Company> getCompanyById(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Company saveCompany(Company companyToSave) {
		// TODO Auto-generated method stub
		return null;
	}

    // Add more methods as needed based on your business requirements
}
