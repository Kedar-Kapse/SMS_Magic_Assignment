package Company.Controller;

import Company.Entity.Client;
import Company.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    private final ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return ResponseEntity.ok("Client created successfully");
    }

    @PutMapping("/update/{clientId}/{fieldName}/{newValue}")
    public ResponseEntity<String> updateClientField(
            @PathVariable Long clientId,
            @PathVariable String fieldName,
            @PathVariable String newValue) {
        try {
            clientService.updateClientField(clientId, fieldName, newValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Client field updated successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Client>> listClients() {
        List<Client> clients = clientService.listClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        Optional<Client> optionalClient = clientService.getClientById(clientId);

        if (optionalClient.isPresent()) {
            return ResponseEntity.ok(optionalClient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Client deleted successfully");
    }
}
