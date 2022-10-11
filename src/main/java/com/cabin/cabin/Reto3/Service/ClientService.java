package com.cabin.cabin.Reto3.Service;

import com.cabin.cabin.Reto3.Interfaz.Client;
import com.cabin.cabin.Reto3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(Integer id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if(e.isPresent()){

                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }
    }
