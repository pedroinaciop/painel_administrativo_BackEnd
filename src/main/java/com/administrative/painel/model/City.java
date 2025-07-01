package com.administrative.painel.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import com.administrative.painel.dto.CityDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Setter
@Getter
@EqualsAndHashCode(of = "city_id")
@Entity(name = "cities")
public class City {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long city_id;

    @Column(length = 35, nullable = false)
    private String cityName;

    @Column(length = 2, nullable = false)
    private String uf;

    @Column(unique = true, nullable = false)
    private Integer ibgeCode;

    @Column(nullable = false)
    private String countryCode;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updateDate;

    @Column(length = 50)
    private String updateUser;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createDate;

    @Column(length = 50, updatable = false)
    private String createUser;

    public City() {}

    public City(CityDTO dados) {
        this.city_id = dados.city_id();
        this.cityName = dados.cityName();
        this.uf = dados.uf();
        this.ibgeCode = dados.ibgeCode();
        this.countryCode = dados.countryCode();
        this.updateDate = dados.updateDate();
        this.updateUser = dados.updateUser();
        this.createDate = dados.createDate();
        this.createUser = dados.createUser();
    }
}
