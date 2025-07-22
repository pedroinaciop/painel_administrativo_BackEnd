package com.administrative.painel.dto;

import com.administrative.painel.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record RegisterDTO(String fullName,
                          String login,
                          String password,
                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
                          LocalDateTime updateDate,
                          UserRole role) {
}
