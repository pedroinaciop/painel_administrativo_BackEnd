package com.administrative.painel.service;

import com.administrative.painel.dto.CompanyDTO;
import com.administrative.painel.dto.EditCompanyDTO;
import com.administrative.painel.model.Company;
import com.administrative.painel.repository.CompanyRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyDTO> getCompanies() {
        return convertCompanies(companyRepository.findAll());
    }

    public CompanyDTO getCompanyDTO(Long id) {
        return convertCompany(companyRepository.findById(id));
    }

    public Company getCompanyByID(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    public void editCompany(Long id, String corporateReason, String stateRegistration, String email, String phone, String cep, String street, Integer numberAddress, String neighborhood, String city, String state, String complement, LocalDateTime date, String updateUser) {
        Company company = getCompanyByID(id);

        company.setCorporateReason(corporateReason);
        company.setStateRegistration(stateRegistration);
        company.setEmail(email);
        company.setPhone(phone);
        company.setCep(cep);
        company.setStreet(street);
        company.setNumberAddress(numberAddress);
        company.setNeighborhood(neighborhood);
        company.setCity(city);
        company.setState(state);
        company.setComplement(complement);
        company.setUpdateDate(date);
        company.setUpdateUser(updateUser);

        companyRepository.save(company);
    }

    public CompanyDTO convertCompany(Optional<Company> company) {
        return company
                .map(c -> new CompanyDTO(c.getCompany_id(), c.getCnpj(), c.getCorporateReason(), c.getStateRegistration(), c.getEmail(), c.getPhone(), c.getCep(), c.getStreet(), c.getNumberAddress(), c.getNeighborhood(), c.getCity(), c.getState(), c.getComplement(), c.getUpdateDate(), c.getUpdateUser(), c.getCreateDate(), c.getCreateUser()))
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    public List<CompanyDTO> convertCompanies(List<Company> companies) {
        return companies
                .stream()
                .map(c -> new CompanyDTO(c.getCompany_id(), c.getCnpj(), c.getCorporateReason(), c.getStateRegistration(), c.getEmail(), c.getPhone(), c.getCep(), c.getStreet(), c.getNumberAddress(), c.getNeighborhood(), c.getCity(), c.getState(), c.getComplement(), c.getUpdateDate(), c.getUpdateUser(), c.getCreateDate(), c.getCreateUser()))
                .collect(Collectors.toList());
    }
}
