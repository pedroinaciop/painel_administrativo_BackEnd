package com.administrative.painel.model;

import com.administrative.painel.dto.ClientDTO;
import com.administrative.painel.enums.ClientType;
import com.administrative.painel.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "clientId")
@Entity(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClientType clientType;

    @Column(nullable = false)
    private boolean active = true;

    @Column(length = 80, nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate birthDate;

    @Column(unique = true, length = 14)
    private String cpfCnpj;

    @Column(length = 3, nullable = false)
    private String division;

    @Column(length = 9, nullable = false, unique = true)
    private String rg;

    @Column(length = 80, nullable = false)
    private String email;

    @Column(length = 25)
    private String phone;

    @Column(length = 25)
    private String secondaryPhone;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 80, nullable = false)
    private String street;

    @Column(nullable = false)
    private Integer numberAddress;

    @Column(length = 50, nullable = false)
    private String neighborhood;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 7, nullable = false)
    private String ibgeCityCode;

    @Column(length = 2, nullable = false)
    private String state;

    @Column(length = 55)
    private String complement;

    @Column(length = 250)
    private String notes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updateDate;

    @Column(length = 50)
    private String updateUser;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createDate;

    @Column(length = 50, updatable = false)
    private String createUser;

    public Client() {
    }

    public Client(Long clientId, String fullName, Gender gender, ClientType clientType, String cpfCnpj, boolean active, LocalDate birthDate, String rg, String email, String phone, String secondaryPhone, String cep, String street, Integer numberAddress, String neighborhood, String city, String ibgeCityCode, String state, String complement, String notes, LocalDateTime updateDate, String updateUser, LocalDateTime createDate, String createUser) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.gender = gender;
        this.clientType = clientType;
        this.cpfCnpj = cpfCnpj;
        this.active = active;
        this.birthDate = birthDate;
        this.rg = rg;
        this.email = email;
        this.phone = phone;
        this.secondaryPhone = secondaryPhone;
        this.cep = cep;
        this.street = street;
        this.numberAddress = numberAddress;
        this.neighborhood = neighborhood;
        this.city = city;
        this.ibgeCityCode = ibgeCityCode;
        this.state = state;
        this.complement = complement;
        this.notes = notes;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public Client(ClientDTO dados) {
        this.clientId = dados.clientId();
        this.clientType = dados.clientType();
        this.active = dados.active();

        this.fullName = dados.fullName();
        this.gender = dados.gender();
        this.birthDate = dados.birthDate();

        this.cpfCnpj = dados.cpfCnpj();
        this.rg = dados.rg();
        this.division = dados.division();
        this.email = dados.email();
        this.phone = dados.phone();
        this.secondaryPhone = dados.secondaryPhone();

        this.cep = dados.cep();
        this.street = dados.street();
        this.numberAddress = dados.numberAddress();
        this.neighborhood = dados.neighborhood();
        this.city = dados.city();
        this.ibgeCityCode = dados.ibgeCityCode();
        this.state = dados.state();
        this.complement = dados.complement();
        this.notes = dados.notes();

        this.createDate = dados.createDate();
        this.createUser = dados.createUser();
    }
}