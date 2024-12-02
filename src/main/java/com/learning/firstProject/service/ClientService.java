package com.learning.firstProject.service;

import com.learning.firstProject.model.Client;
import com.learning.firstProject.repository.ClientRepository;
import com.learning.firstProject.exceptions.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClientsByID(Long id){
        return clientRepository.findById(id).orElseThrow(()-> new ClientException(id));
    }

    public ResponseEntity<Client> postClient(Client client){
        Client newClient = clientRepository.save(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    public void deleteClient (Long id){
        clientRepository.deleteById(id);
    }

}
