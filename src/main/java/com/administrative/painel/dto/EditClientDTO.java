package com.administrative.painel.dto;

import com.administrative.painel.enums.ClientType;
import com.administrative.painel.enums.StatusTax;
import com.administrative.painel.enums.TaxRegimeCode;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EditClientDTO(
        Long client_id,
        ClientType clientType,
        boolean active,

        String fullName,
        String fantasyName,
        @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
        LocalDate birthDate,

        String cpfCnpj,
        String stateRegistration,
        String municipalRegistration,
        StatusTax statusTax,
        String rg,
        String email,
        String phone,
        String secondaryPhone,
        Boolean exemptStateRegistration,
        TaxRegimeCode taxRegimeCode,

        String cep,
        String street,
        Integer numberAddress,
        String neighborhood,
        String city,
        String ibgeCityCode,
        String state,
        String country,
        String complement,
        String notes,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime updateDate,
        String updateUser) {
}
