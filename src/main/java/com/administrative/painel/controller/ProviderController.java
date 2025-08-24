package com.administrative.painel.controller;

import com.administrative.painel.dto.EditProviderDTO;
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

    @GetMapping("/editar/fornecedores/{id}")
    public Provider findProviderById(@PathVariable("id") Long id) {
        return providerService.getProviderById(id);
    }

    @GetMapping("/fornecedores")
    public List<ProviderDTO> findAllProvider() {
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

    @Transactional
    @PutMapping("editar/fornecedores/{id}")
    public void editProvider(@PathVariable("id") Long id, @RequestBody EditProviderDTO dto) {
        providerService.editProvider(id, dto.providerName(), dto.updateDate(), dto.updateUser());
    }

    @GetMapping("/fornecedores/{providerName}")
    public List<Provider> findProviderByName(@PathVariable("providerName") String providerName) {
        return providerService.getProvidersByName(providerName);
    }
}
