package com.administrative.painel.model;

import com.administrative.painel.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(of = "category_id")
@Entity(name = "categories")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(unique = true, nullable = false, length = 50)
    private String categoryName;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updateDate;

    @Column(length = 50)
    private String updateUser;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createDate;

    @Column(length = 50, updatable = false)
    private String createUser;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;

    public Category() {}

    public Category(CategoryDTO dados) {
        this.category_id = dados.category_id();
        this.categoryName = dados.categoryName();
        this.updateDate = dados.updateDate();
        this.updateUser = dados.updateUser();
        this.createDate = dados.createDate();
        this.createUser = dados.createUser();
    }
}