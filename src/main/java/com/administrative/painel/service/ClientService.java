package com.administrative.painel.service;

import com.administrative.painel.dto.ClientDTO;
import com.administrative.painel.enums.ClientType;
import com.administrative.painel.enums.Gender;
import com.administrative.painel.model.Client;
import com.administrative.painel.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository repository) {
        this.clientRepository = repository;
    }

    public ClientDTO getClientDTOById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return convertClient(client);
    }

    private Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public List<ClientDTO> getClients() {
        return convertClients(clientRepository.findAll());
    }

    public void editClient(Long clientId, ClientType clientType, boolean active, String fullName, Gender gender, LocalDate birthDate, String cpfCnpj, String division, String rg, String email, String phone, String secondaryPhone, String cep, String street, Integer numberAddress, String neighborhood, String city, String ibgeCityCode, String state, String complement, String notes, LocalDateTime updateDate, String updateUser) {
        Client client = getClientById(clientId);

        client.setClientType(clientType);
        client.setActive(active);
        client.setFullName(fullName);
        client.setGender(gender);
        client.setBirthDate(birthDate);
        client.setCpfCnpj(cpfCnpj);
        client.setDivision(division);
        client.setRg(rg);
        client.setEmail(email);
        client.setPhone(phone);
        client.setSecondaryPhone(secondaryPhone);
        client.setCep(cep);
        client.setStreet(street);
        client.setNumberAddress(numberAddress);
        client.setNeighborhood(neighborhood);
        client.setCity(city);
        client.setIbgeCityCode(ibgeCityCode);
        client.setState(state);
        client.setComplement(complement);
        client.setNotes(notes);
        client.setUpdateDate(updateDate);
        client.setUpdateUser(updateUser);

        clientRepository.save(client);
    }

    private ClientDTO convertClient(Optional<Client> client) {
        return client
                .map(c -> new ClientDTO(c.getClientId(), c.getClientType(), c.isActive(), c.getFullName(), c.getGender(), c.getBirthDate(), c.getCpfCnpj(), c.getDivision(), c.getRg(), c.getEmail(), c.getPhone(), c.getSecondaryPhone(), c.getCep(), c.getStreet(), c.getNumberAddress(), c.getNeighborhood(), c.getCity(), c.getIbgeCityCode(), c.getState(), c.getComplement(), c.getNotes(), c.getUpdateDate(), c.getUpdateUser(), c.getCreateDate(), c.getCreateUser()))
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    private List<ClientDTO> convertClients(List<Client> client) {
        return client
                .stream()
                .map(c -> new ClientDTO(c.getClientId(), c.getClientType(), c.isActive(), c.getFullName(), c.getGender(), c.getBirthDate(), c.getCpfCnpj(), c.getDivision(), c.getRg(), c.getEmail(), c.getPhone(), c.getSecondaryPhone(), c.getCep(), c.getStreet(), c.getNumberAddress(), c.getNeighborhood(), c.getCity(), c.getIbgeCityCode(), c.getState(), c.getComplement(), c.getNotes(), c.getUpdateDate(), c.getUpdateUser(), c.getCreateDate(), c.getCreateUser()))
                .collect(Collectors.toList());
    }
}