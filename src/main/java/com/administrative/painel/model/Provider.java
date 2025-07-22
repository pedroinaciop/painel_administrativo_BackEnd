package com.administrative.painel.model;

import com.administrative.painel.dto.ProviderDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(of = "provider_id")
@Entity(name = "providers")
public class Provider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provider_id;

    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 80)
    private String providerName;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updateDate;

    @Column(length = 50)
    private String updateUser;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createDate;

    @Column(length = 50, updatable = false)
    private String createUser;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;

    public Provider() {}

    public Provider(ProviderDTO dados) {
        this.provider_id = dados.provider_id();
        this.cnpj = dados.cnpj();
        this.providerName = dados.provider();
        this.updateDate = dados.updateDate();
        this.updateUser = dados.updateUser();
        this.createDate = dados.createDate();
        this.createUser = dados.createUser();
    }

    public Provider(Long provider_id, String cnpj, String providerName, LocalDateTime updateDate, String updateUser, LocalDateTime createDate, String createUser) {
        this.provider_id = provider_id;
        this.cnpj = cnpj;
        this.providerName = providerName;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.createUser = createUser;
    }
}