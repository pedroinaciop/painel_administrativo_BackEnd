package com.administrative.painel.controller;

import com.administrative.painel.dto.CompanyDTO;
import com.administrative.painel.dto.EditCompanyDTO;
import com.administrative.painel.model.Company;
import com.administrative.painel.repository.CompanyRepository;
import com.administrative.painel.service.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/editar/empresas/{id}")
    public CompanyDTO getCompanyByID(@PathVariable Long id) {
        return companyService.getCompanyDTO(id);
    }

    @GetMapping("/empresas")
    public List<CompanyDTO> findAllCompanies() {
        return companyService.getCompanies();
    }

    @Transactional
    @PostMapping("/cadastros/empresas/novo")
    public void createCompany(@RequestBody CompanyDTO dados) {
        companyRepository.save(new Company(dados));
    }

    @Transactional
    @DeleteMapping("/empresas/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyRepository.deleteById(id);
    }

    @Transactional
    @PutMapping("/editar/empresas/{id}")
    public void editCompany(@PathVariable("id") Long id, @RequestBody EditCompanyDTO dto) {
        companyService.editCompany(id, dto.corporateReason(), dto.stateRegistration(), dto.email(), dto.phone(), dto.cep(), dto.street(), dto.numberAddress(), dto.neighborhood(), dto.city(), dto.state(), dto.complement(), dto.updateDate(), dto.updateUser());
    }
}
