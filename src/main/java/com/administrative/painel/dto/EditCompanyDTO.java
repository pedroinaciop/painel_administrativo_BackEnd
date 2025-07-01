package com.administrative.painel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record EditCompanyDTO(
        String corporateReason,
        String stateRegistration,
        String email,
        String phone,
        String cep,
        String street,
        Integer numberAddress,
        String neighborhood,
        String city,
        String state,
        String complement,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime updateDate,
        String updateUser) {
}
