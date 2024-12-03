package com.learning.springProject.service;

import com.learning.springProject.model.Client;
import com.learning.springProject.repository.ClientRepository;
import com.learning.springProject.exceptions.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClientsByID(Long id){
        return clientRepository.findById(id).orElseThrow(()-> new ClientException());
    }

    public ResponseEntity<Client> postClient(Client client){
        Client newClient = clientRepository.save(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    public void deleteClient (Long id){
        clientRepository.deleteById(id);
    }

}
