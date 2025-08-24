package com.administrative.painel.controller;

import com.administrative.painel.dto.ClientDTO;
import com.administrative.painel.dto.EditCategoryDTO;
import com.administrative.painel.dto.EditClientDTO;
import com.administrative.painel.model.Client;
import com.administrative.painel.repository.ClientRepository;
import com.administrative.painel.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class ClientController {
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    public ClientController(ClientRepository repository, ClientService clientService) {
        this.clientRepository = repository;
        this.clientService = clientService;
    }

    @Transactional
    @PostMapping("/cadastros/clientes/novo")
    public void registerClient(@RequestBody ClientDTO client) {
        clientRepository.save(new Client(client));
    }

    @Transactional
    @DeleteMapping("/clientes/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientRepository.deleteById(id);
    }

    @GetMapping("/clientes")
    public List<ClientDTO> getAllClients() {
        return clientService.getClients();
    }

    @GetMapping("/editar/clientes/{id}")
    public ClientDTO getClientById(@PathVariable("id") Long id) {
        return clientService.getClientDTOById(id);
    }

    @Transactional
    @PutMapping("/editar/clientes/{id}")
    public void editClientByID(@PathVariable("id") Long id, @RequestBody EditClientDTO dto) {
        clientService.editClient(id, dto.clientType(), dto.active(), dto.fullName(), dto.fantasyName(), dto.stateRegistration(), dto.municipalRegistration(), dto.statusTax(), dto.birthDate(), dto.cpfCnpj(), dto.rg(), dto.email(), dto.phone(), dto.secondaryPhone(), dto.cep(), dto.street(), dto.numberAddress(), dto.neighborhood(), dto.city(), dto.ibgeCityCode(), dto.state(), dto.country(), dto.complement(), dto.notes(), dto.exemptStateRegistration(), dto.taxRegimeCode(), dto.updateDate(), dto.updateUser());
    }
}