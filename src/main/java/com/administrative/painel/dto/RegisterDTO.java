package com.administrative.painel.dto;

import com.administrative.painel.model.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record RegisterDTO(String fullName,
                          String login,
                          String password,
                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
                          Date updateDate,
                          UserRole role) {
}
