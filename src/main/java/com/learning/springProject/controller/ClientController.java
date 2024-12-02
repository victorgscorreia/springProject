package com.learning.springProject.controller;

import com.learning.springProject.model.Client;
import com.learning.springProject.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/client")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/client/{id}")
    public Client getClientByID(@PathVariable Long id){
        return clientService.getClientsByID(id);
    }

    @PostMapping("/client")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        return clientService.postClient(client);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
