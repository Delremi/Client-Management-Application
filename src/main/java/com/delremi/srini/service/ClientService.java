package com.delremi.srini.service;

import com.delremi.srini.dto.ClientCreationDto;
import com.delremi.srini.dto.ClientDisplayDto;
import com.delremi.srini.exception.EntityNotFoundException;
import com.delremi.srini.model.Client;
import com.delremi.srini.model.Country;
import com.delremi.srini.model.User;
import com.delremi.srini.repository.ClientRepository;
import com.delremi.srini.security.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserService userService;

    public ClientDisplayDto saveClient(ClientCreationDto clientCreationDto) throws EntityNotFoundException {
        Client client = new Client();
        client.setFirstName(clientCreationDto.getFirstName());
        client.setLastName(clientCreationDto.getLastName());
        client.setUsername(clientCreationDto.getUsername());
        client.setEmail(clientCreationDto.getEmail());
        client.setAddress(clientCreationDto.getAddress());
        Country country = countryService.getCountry(clientCreationDto.getCountryId());
        client.setCountry(country);
        int userId = AuthUtils.getAuthenticatedUserId();
        User user = userService.getUser(userId);
        client.setCreatedBy(user);
        clientRepository.save(client);
        return client.toDisplayDto();
    }

    public List<ClientDisplayDto> getClients() throws EntityNotFoundException {
        User user = userService.getUser(AuthUtils.getAuthenticatedUserId());
        List<Client> clients = clientRepository.findAllByCreatedBy(user);
        return clients.stream().map(Client::toDisplayDto).collect(Collectors.toList());
    }
}
