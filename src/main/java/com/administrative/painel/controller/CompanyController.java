package com.administrative.painel.controller;

import com.administrative.painel.dto.CompanyDTO;
import com.administrative.painel.model.Company;
import com.administrative.painel.repository.CompanyRepository;
import com.administrative.painel.service.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/empresas")
    public List<CompanyDTO> findAllCompanies() {
        return companyService.getCompanies();
    }

    @Transactional
    @PostMapping("cadastros/empresas/novo")
    public void createCompany(@RequestBody CompanyDTO dados) {
        companyRepository.save(new Company(dados));
    }

    @Transactional
    @DeleteMapping("/empresas/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyRepository.deleteById(id);
    }
}
