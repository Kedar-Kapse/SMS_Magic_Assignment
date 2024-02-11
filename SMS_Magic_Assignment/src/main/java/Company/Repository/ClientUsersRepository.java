package Company.Repository;

import Company.Entity.Client;
import Company.Entity.ClientUsers;
import Company.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientUsersRepository extends JpaRepository<ClientUsers, Long> {

    
    List<ClientUsers> findByClient(Client client);

   
    List<ClientUsers> findByUser(User user);

   
    List<ClientUsers> findByActiveTrue();

   
    List<ClientUsers> findByDeletedAtIsNotNull();
}
