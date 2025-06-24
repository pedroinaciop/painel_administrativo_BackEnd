package com.administrative.painel.model;

import com.administrative.painel.dto.CompanyDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

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
    private Date updateDate;
    @Column(length = 50)
    private String updateUser;

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
    }

    public Company(Long company_id, String cnpj, String corporateReason, String stateRegistration, String email, String phone, String cep, String street, Integer numberAddress, String neighborhood, String city, String state, String complement, Date updateDate, String updateUser) {
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
    }

    public Long getCompany_id() {
        return company_id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCorporateReason() {
        return corporateReason;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumberAddress() {
        return numberAddress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getComplement() {
        return complement;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setCorporateReason(String corporateReason) {
        this.corporateReason = corporateReason;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumberAddress(Integer numberAddress) {
        this.numberAddress = numberAddress;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
