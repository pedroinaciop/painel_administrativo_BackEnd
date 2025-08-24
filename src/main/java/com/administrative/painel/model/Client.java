package com.administrative.painel.model;

import com.administrative.painel.dto.ClientDTO;
import com.administrative.painel.enums.ClientType;
import com.administrative.painel.enums.StatusTax;
import com.administrative.painel.enums.TaxRegimeCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(of = "client_id")
@Entity(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClientType clientType;

    private boolean active;

    @Column(nullable = false)
    private String fullName;

    private String fantasyName;

    private String country;

    private String municipalRegistration;

    @Enumerated(EnumType.STRING)
    private TaxRegimeCode taxRegimeCode;

    private Boolean exemptStateRegistration;

    @Enumerated(EnumType.STRING)
    private StatusTax statusTax;

    private String stateRegistration;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate birthDate;

    @Column(updatable = false, unique = true)
    private String cpfCnpj;

    @Column(unique = true)
    private String rg;

    @Column(nullable = false)
    private String email;

    private String phone;

    private String secondaryPhone;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private Integer numberAddress;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String ibgeCityCode;

    @Column(nullable = false)
    private String state;

    private String complement;

    private String notes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updateDate;

    private String updateUser;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createDate;

    @Column(updatable = false)
    private String createUser;

    public Client() {
    }

    public Client(Long client_id, String fullName, ClientType clientType, String cpfCnpj, boolean active, String fantasyName, String country, String stateRegistration, String municipalRegistration, StatusTax statusTax, LocalDate birthDate, String rg, String email, String phone, String secondaryPhone, String cep, String street, Integer numberAddress, String neighborhood, String city, String ibgeCityCode, String state, String complement, String notes, Boolean exemptStateRegistration, TaxRegimeCode taxRegimeCode, LocalDateTime updateDate, String updateUser, LocalDateTime createDate, String createUser) {
        this.client_id = client_id;
        this.fullName = fullName;
        this.clientType = clientType;
        this.cpfCnpj = cpfCnpj;
        this.active = active;
        this.birthDate = birthDate;
        this.fantasyName = fantasyName;
        this.municipalRegistration = municipalRegistration;
        this.stateRegistration = stateRegistration;
        this.statusTax = statusTax;
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
        this.country = country;
        this.complement = complement;
        this.notes = notes;
        this.exemptStateRegistration = exemptStateRegistration;
        this.taxRegimeCode = taxRegimeCode;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public Client(ClientDTO dados) {
        this.client_id = dados.client_id();
        this.clientType = dados.clientType();
        this.active = dados.active();

        this.fullName = dados.fullName();
        this.fantasyName = dados.fantasyName();
        this.birthDate = dados.birthDate();

        this.cpfCnpj = dados.cpfCnpj();
        this.country = dados.country();
        this.stateRegistration = dados.stateRegistration();
        this.municipalRegistration = dados.municipalRegistration();
        this.statusTax = dados.statusTax();
        this.rg = dados.rg();
        this.email = dados.email();
        this.phone = dados.phone();
        this.secondaryPhone = dados.secondaryPhone();
        this.exemptStateRegistration = dados.exemptStateRegistration();
        this.taxRegimeCode = dados.taxRegimeCode();

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

    public Long getClientId() {
        return client_id;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(Integer numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIbgeCityCode() {
        return ibgeCityCode;
    }

    public void setIbgeCityCode(String ibgeCityCode) {
        this.ibgeCityCode = ibgeCityCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMunicipalRegistration() {
        return municipalRegistration;
    }

    public void setMunicipalRegistration(String municipalRegistration) {
        this.municipalRegistration = municipalRegistration;
    }

    public StatusTax getStatusTax() {
        return statusTax;
    }

    public void setStatusTax(StatusTax statusTax) {
        this.statusTax = statusTax;
    }

    public TaxRegimeCode getTaxRegimeCode() {
        return taxRegimeCode;
    }

    public void setTaxRegimeCode(TaxRegimeCode taxRegimeCode) {
        this.taxRegimeCode = taxRegimeCode;
    }

    public Boolean getExemptStateRegistration() {
        return exemptStateRegistration;
    }

    public void setExemptStateRegistration(Boolean exemptStateRegistration) {
        this.exemptStateRegistration = exemptStateRegistration;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}