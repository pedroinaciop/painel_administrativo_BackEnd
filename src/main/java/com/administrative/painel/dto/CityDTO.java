package com.administrative.painel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CityDTO (
        Long city_id,

        String cityName,
        String uf,
        Integer ibgeCode,
        String countryCode,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime updateDate,
        String updateUser,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime createDate,
        String createUser) {}