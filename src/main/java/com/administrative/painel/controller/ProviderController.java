package com.administrative.painel.controller;

import com.administrative.painel.dto.ProviderDTO;
import com.administrative.painel.model.Provider;
import com.administrative.painel.repository.ProviderRepository;
import com.administrative.painel.service.ProviderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProviderService providerService;

    @GetMapping("/fornecedores")
    public List<ProviderDTO> findAllCategory() {
        return providerService.getProviders();
    }

    @Transactional
    @PostMapping("/cadastros/fornecedores/novo")
    public void registerProvider(@RequestBody ProviderDTO dados) {
        providerRepository.save(new Provider(dados));
    }

    @Transactional
    @DeleteMapping("/fornecedores/{id}")
    public void deleteProvider(@PathVariable("id") Long id) {
        providerRepository.deleteById(id);
    }
}
