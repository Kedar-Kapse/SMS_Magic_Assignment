package Company.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Company.Entity.Client;
import Company.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public List<Client> getActiveClients() {
        return clientRepository.findActiveClients();
    }

    public List<Client> getClientsByUserId(Long userId) {
        return clientRepository.findClientsByUserId(userId);
    }

    public Client getClientByName(String name) {
        return clientRepository.findByName(name);
    }

    public Client updateClient(Long id, Client updatedClient) {
       
        Optional<Client> existingClientOptional = clientRepository.findById(id);
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            
           
            existingClient.setName(updatedClient.getName());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setPhone(updatedClient.getPhone());
           
            
            return clientRepository.save(existingClient);
        } else {
          
            return null;
        }
    }
    public Client updateClientField(Long clientId, String fieldName, String updatedValue) throws Exception {
      
        Optional<Client> optionalClient = clientRepository.findById(clientId);

        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();

           
            switch (fieldName) {
                case "name":
                    existingClient.setName(updatedValue);
                    break;
               

                default:
                    throw new IllegalArgumentException("Invalid field name: " + fieldName);
            }

           
            return clientRepository.save(existingClient);
        } else {
            throw new Exception("Client not found with ID: " + clientId);
        }
    }
}
