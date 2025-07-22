package com.administrative.painel.dto;

import com.administrative.painel.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserDTO (
        Long user_id,
        String fullName,
        String email,
        String password,
        UserRole role,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime updateDate,
        String updateUser,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime createDate,
        String createUser) {
}
