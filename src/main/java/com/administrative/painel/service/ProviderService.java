package com.administrative.painel.service;

import com.administrative.painel.dto.ProviderDTO;
import com.administrative.painel.model.Provider;
import com.administrative.painel.repository.ProviderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    //Lista fornecedores e converte-os para fornecedorDTO
    public List<ProviderDTO> getProviders() {
        return convertDataList(providerRepository.findAll());
    }

    public ProviderDTO getProviderDTO(Long id) {
        return(convertData(providerRepository.findById(id)));
    }

    //Lista fornecedores
    public Provider getProviderById(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado!"));
    }

    public void editProvider(Long id, String providerName) {
        Provider provider = getProviderById(id);
        provider.setProvider(providerName);

        providerRepository.save(provider);
    }

    //Converte fornecedores para fornecedoresDTO
    public ProviderDTO convertData(Optional<Provider> provider) {
        return provider
                .map(p -> new ProviderDTO(p.getProvider_id(), p.getCnpj(), p.getProvider(), p.getUpdateDate(), p.getUpdateUser()))
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada!"));
    }

    //Converte fornecedores para fornecedoresDTO
    public List<ProviderDTO> convertDataList(List<Provider> providers) {
        return providers
                .stream()
                .map(p -> new ProviderDTO(p.getProvider_id(), p.getCnpj(), p.getProvider(), p.getUpdateDate(), p.getUpdateUser()))
                .collect(Collectors.toList());
    }
}