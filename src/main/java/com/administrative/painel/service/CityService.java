package com.administrative.painel.service;

import com.administrative.painel.dto.CategoryDTO;
import com.administrative.painel.dto.CityDTO;
import com.administrative.painel.model.Category;
import com.administrative.painel.model.City;
import com.administrative.painel.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityDTO findCityByID(Long id) {
        return convertData(cityRepository.findById(id));
    }

    //pesquisa as cidade no banco convertendo em cidadesDTO
    public List<CityDTO> findAllCities() {
        return convertDataList(cityRepository.findAll());
    }

    //Converte uma lista de cidades em uma lista de cidadesDTO
    public List<CityDTO> convertDataList(List<City> cities) {
        return cities
                .stream()
                .map(c -> new CityDTO(c.getCity_id(), c.getCityName(), c.getUf(), c.getIbgeCode(), c.getCountryCode(), c.getUpdateDate(), c.getUpdateUser(), c.getCreateDate(), c.getCreateUser()))
                .collect(Collectors.toList());
    }

    //Converte uma lista de cidades em uma lista de cidadesDTO
    public CityDTO convertData(Optional<City> city) {
        return city
                .map(c -> new CityDTO(c.getCity_id(), c.getCityName(), c.getUf(), c.getIbgeCode(), c.getCountryCode(), c.getUpdateDate(), c.getUpdateUser(), c.getCreateDate(), c.getCreateUser()))
                .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada!"));
    }
}
