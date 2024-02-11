package Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import Company.Entity.Client;
import Company.Entity.Company;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    List<Client> findByCompany(Company company);

    @Query("SELECT c FROM Client c WHERE c.active = true")
    List<Client> findActiveClients();

    @Query(value = "SELECT * FROM client c WHERE c.user_id = :userId", nativeQuery = true)
    List<Client> findByUserId(@Param("userId") Long userId);

    Client findByName(String string);

    List<Client> findClientsByUserId(Long userId);

}
