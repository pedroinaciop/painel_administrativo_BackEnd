package com.administrative.painel.model;

import com.administrative.painel.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(of = "category_id")
@Entity(name = "categories")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(unique = true, nullable = false, length = 50)
    private String categoryName;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date updateDate;
    @Column(length = 50)
    private String updateUser;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;

    public Category() {}

    public Category(CategoryDTO dados) {
        this.category_id = dados.category_id();
        this.categoryName = dados.categoryName();
        this.updateDate = dados.updateDate();
        this.updateUser = dados.updateUser();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}