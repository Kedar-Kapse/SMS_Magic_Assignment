package Dashboard.Controller;

import Company.Controller.ClientsController;
import Company.Entity.Client;
import Company.Service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(ClientsController.class)
class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientsController clientController;

    @Test
    void testListClients() {
        // Setup
        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("Client 1");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("Client 2");

        List<Client> mockClients = Arrays.asList(client1, client2);

       
        when(clientService.getActiveClients()).thenReturn(mockClients);

        
        ResponseEntity<List<Client>> result = clientController.listClients();

        
        assertIterableEquals(mockClients, result.getBody());
    }

   
}
