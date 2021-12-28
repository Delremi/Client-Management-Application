package com.delremi.srini.service;

import com.delremi.srini.dto.ClientCreationDto;
import com.delremi.srini.exception.EntityNotFoundException;
import com.delremi.srini.model.Client;
import com.delremi.srini.model.User;
import com.delremi.srini.repository.ClientRepository;
import com.delremi.srini.security.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;

    public void saveClient(ClientCreationDto clientCreationDto) throws EntityNotFoundException {
        Client client = new Client();
        client.setFirstName(clientCreationDto.getFirstName());
        client.setLastName(clientCreationDto.getLastName());
        client.setUsername(clientCreationDto.getUsername());
        client.setEmail(clientCreationDto.getEmail());
        client.setAddress(clientCreationDto.getAddress());
        client.setCountry(clientCreationDto.getCountry());
        int userId = AuthUtils.getAuthenticatedUserId();
        User user = userService.getUser(userId);
        client.setCreatedBy(user);
        clientRepository.save(client);
    }

    public List<Client> getClients() throws EntityNotFoundException {
        User user = userService.getUser(AuthUtils.getAuthenticatedUserId());
        return clientRepository.findAllByCreatedBy(user);
    }

    public Client getClient(int id) throws EntityNotFoundException {
        User user = userService.getUser(AuthUtils.getAuthenticatedUserId());
        Client client = clientRepository.findByIdAndCreatedBy(id, user);
        if (client == null) {
            throw new EntityNotFoundException(Client.class, id);
        }
        return client;
    }

    public void updateClient(int id, ClientCreationDto clientCreationDto) throws EntityNotFoundException {
        Client client = getClient(id);
        client.setFirstName(clientCreationDto.getFirstName());
        client.setLastName(clientCreationDto.getLastName());
        client.setUsername(clientCreationDto.getUsername());
        client.setEmail(clientCreationDto.getEmail());
        client.setAddress(clientCreationDto.getAddress());
        client.setCountry(clientCreationDto.getCountry());
        clientRepository.save(client);
    }
}
