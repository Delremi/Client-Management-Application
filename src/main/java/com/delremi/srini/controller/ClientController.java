package com.delremi.srini.controller;

import com.delremi.srini.dto.ClientCreationDto;
import com.delremi.srini.dto.ClientDisplayDto;
import com.delremi.srini.exception.EntityNotFoundException;
import com.delremi.srini.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDisplayDto> getClients() {
        return clientService.getClients();
    }

    @PostMapping
    public ClientDisplayDto saveClient(@RequestBody @Valid ClientCreationDto clientCreationDto) throws EntityNotFoundException {
        return clientService.saveClient(clientCreationDto);
    }
}
