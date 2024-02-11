package Dashboard.Service;

import Company.Entity.Client;
import Company.Repository.ClientRepository;
import Company.Service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClientServiceTests {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void testCreateClient() {
        // Create a new Client
        Client newClient = new Client();
        newClient.setName("John Doe");

        // Test the createClient method
        clientService.saveClient(newClient);

        // Verify that the clientRepository's save method was called once with the new client
        verify(clientRepository, times(1)).save(newClient);
    }

    @Test
    public void testUpdateClientField() {
        // Create an existing Client
        Client existingClient = new Client();
        existingClient.setId(1L);
        existingClient.setName("Jane Doe");

        // Mock the behavior of ClientRepository.findById
        when(clientRepository.findById(1L)).thenReturn(Optional.of(existingClient));

        // Test the updateClientField method
        try {
            Client updatedClient = clientService.updateClientField(1L, "name", "Updated Name");

            // Verify that the existing client's name has been updated
            assertEquals("Updated Name", updatedClient.getName());
        } catch (Exception e) {
            // Handle the exception, or rethrow it if necessary
            e.printStackTrace();
        }
    }


    @Test
    public void testListClients() {
        // Mock the behavior of ClientRepository.findActiveClients
        List<Client> mockClients = new ArrayList<>();
        mockClients.add(new Client());
        mockClients.add(new Client());

        when(clientRepository.findActiveClients()).thenReturn(mockClients);

        // Test the listClients method
        List<Client> result = clientService.getActiveClients();

        // Verify that the result contains the expected clients
        assertIterableEquals(mockClients, result);
    }

    // Add more test methods as needed for other service methods

    // For example:
    // @Test
    // public void testDeleteClient() {
    //     // Implement the test for deleteClient method
    // }

    // @Test
    // public void testGetClientByEmail() {
    //     // Implement the test for getClientByEmail method
    // }

    // @Test
    // public void testGetActiveClients() {
    //     // Implement the test for getActiveClients method
    // }

    // ... add more test methods for other service methods
}
