package com.administrative.painel.dto;

import com.administrative.painel.enums.ClientType;
import com.administrative.painel.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClientDTO(
        Long clientId,
        ClientType clientType,
        boolean active,

        String fullName,
        Gender gender,
        @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
        LocalDate birthDate,

        String cpfCnpj,
        String division,
        String rg,
        String email,
        String phone,
        String secondaryPhone,

        String cep,
        String street,
        Integer numberAddress,
        String neighborhood,
        String city,
        String ibgeCityCode,
        String state,
        String complement,
        String notes,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime updateDate,
        String updateUser,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime createDate,
        String createUser) {}
