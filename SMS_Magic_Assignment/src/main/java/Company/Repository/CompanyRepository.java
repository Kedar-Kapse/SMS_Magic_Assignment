package Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Company.Entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Custom query to find companies by name
    Company findByName(String name);
}
