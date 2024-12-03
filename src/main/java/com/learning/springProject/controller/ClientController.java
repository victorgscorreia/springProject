package com.learning.springProject.controller;

import com.learning.springProject.model.Client;
import com.learning.springProject.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping()
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping(params = "id")
    public Client getClientByID(@RequestParam("id") Long id){
        return clientService.getClientsByID(id);
    }

    @PostMapping()
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        return clientService.postClient(client);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deleteClient(@RequestParam("id") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
