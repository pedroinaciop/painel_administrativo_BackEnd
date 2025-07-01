package com.administrative.painel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public record EditCategoryDTO(
        String categoryName,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime updateDate,
        String updateUser) {}
