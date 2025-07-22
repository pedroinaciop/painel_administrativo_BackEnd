package com.administrative.painel.model;

import com.administrative.painel.dto.CompanyDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;


@Setter
@Getter
@EqualsAndHashCode(of = "company_id")
@Entity(name = "companies")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_id;

    @Column(length = 14, nullable = false)
    private String cnpj;

    @Column(length = 144, nullable = false)
    private String corporateReason;

    @Column(length = 14)
    private String stateRegistration;

    @Column(length = 80, nullable = false)
    private String email;

    @Column(length = 25)
    private String phone;

    @Column(length = 9, nullable = false)
    private String cep;

    @Column(length = 80, nullable = false)
    private String street;

    @Column(nullable = false)
    private Integer numberAddress;

    @Column(length = 50, nullable = false)
    private String neighborhood;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 2, nullable = false)
    private String state;

    @Column(length = 55)
    private String complement;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updateDate;

    @Column(length = 50)
    private String updateUser;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createDate;

    @Column(length = 50, updatable = false)
    private String createUser;

    public Company() {
    }

    public Company(CompanyDTO dados) {
        this.company_id = dados.company_id();
        this.cnpj = dados.cnpj();
        this.corporateReason = dados.corporateReason();
        this.stateRegistration = dados.stateRegistration();
        this.email = dados.email();
        this.phone = dados.phone();
        this.cep = dados.cep();
        this.street = dados.street();
        this.numberAddress = dados.numberAddress();
        this.neighborhood = dados.neighborhood();
        this.city = dados.city();
        this.state = dados.state();
        this.complement = dados.complement();
        this.updateDate = dados.updateDate();
        this.updateUser = dados.updateUser();
        this.createUser = dados.createUser();
        this.createDate = dados.createDate();
    }

    public Company(Long company_id, String cnpj, String corporateReason, String stateRegistration, String email, String phone, String cep, String street, Integer numberAddress, String neighborhood, String city, String state, String complement, LocalDateTime updateDate, String updateUser, String createUser, LocalDateTime createDate) {
        this.company_id = company_id;
        this.cnpj = cnpj;
        this.corporateReason = corporateReason;
        this.stateRegistration = stateRegistration;
        this.email = email;
        this.phone = phone;
        this.cep = cep;
        this.street = street;
        this.numberAddress = numberAddress;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.complement = complement;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.createUser = createUser;

    }
}