package com.administrative.painel.controller;

import com.administrative.painel.dto.CityDTO;
import com.administrative.painel.model.City;
import com.administrative.painel.repository.CityRepository;
import com.administrative.painel.service.CityService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CityController {
    private final CityRepository cityRepository;
    private final CityService cityService;

    public CityController(CityRepository cityRepository, CityService cityService) {
        this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

    @GetMapping("/editar/cidades/{id}")
    public CityDTO findCityByID(@PathVariable("id") Long id) {
        return cityService.findCityByID(id);
    }

    @GetMapping("/cidades")
    public List<CityDTO> findAllCities() {
        return cityService.findAllCities();
    }

    @Transactional
    @PostMapping("cadastros/cidades/novo")
    public void registerCity(@RequestBody CityDTO dados) {
        cityRepository.save(new City(dados));
    }

    @Transactional
    @DeleteMapping("/cidades/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityRepository.deleteById(id);
    }
}
