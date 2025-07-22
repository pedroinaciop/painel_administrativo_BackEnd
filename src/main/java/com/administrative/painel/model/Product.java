package com.administrative.painel.model;

import com.administrative.painel.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;


@Setter
@Getter
@EqualsAndHashCode(of = "product_id")
@Entity(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(length = 80)
    private String productName;

    @Column(length = 50, unique = true)
    private String referenceCode;

    private BigDecimal price;

    private BigDecimal pricePromocional;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    private Integer stockAlert;

    @Column(length = 50)
    private String color;

    @Column(length = 50)
    private String productSize;

    @Column(length = 50)
    private String barCodeField;

    @Column(length = 1500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer packagingQuantity;

    private String unity;

    private Double netWeight;

    private Double grossWeight;

    @Column(length = 50)
    private String dimension;

    @Column(length = 20)
    private String anvisaRegister;

    @Column(length = 20)
    private String origin;

    @Column(length = 20)
    private String stockLocation;

    private BigDecimal icms;

    private String cfop;

    private String ncm;

    private String cst;

    private String image;

    private Boolean active;

    private Boolean sterility;

    private Boolean freeShipping;

    private Boolean perishable;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updateDate;

    @Column(length = 50)
    private String updateUser;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createDate;

    @Column(length = 50, updatable = false)
    private String createUser;

    public Product() {
    }

    public Product(Long product_id, String productName, String referenceCode, BigDecimal price, BigDecimal pricePromocional, Provider provider, Integer stockAlert, String color, String size, String barCodeField, String description, Category category, Integer packagingQuantity, String unity, Double netWeight, Double grossWeight, String dimension, String anvisaRegister, String origin, String stockLocation, BigDecimal icms, String cfop, String ncm, String cst, String image, Boolean active, Boolean sterility, Boolean freeShipping, Boolean perishable, LocalDateTime updateDate, String updateUser, LocalDateTime createDate, String createUser) {
        this.product_id = product_id;
        this.productName = productName;
        this.referenceCode = referenceCode;
        this.price = price;
        this.pricePromocional = pricePromocional;
        this.provider = provider;
        this.stockAlert = stockAlert;
        this.color = color;
        this.productSize = size;
        this.barCodeField = barCodeField;
        this.description = description;
        this.category = category;
        this.packagingQuantity = packagingQuantity;
        this.unity = unity;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.dimension = dimension;
        this.anvisaRegister = anvisaRegister;
        this.origin = origin;
        this.stockLocation = stockLocation;
        this.icms = icms;
        this.cfop = cfop;
        this.ncm = ncm;
        this.cst = cst;
        this.image = image;
        this.active = active;
        this.sterility = sterility;
        this.freeShipping = freeShipping;
        this.perishable = perishable;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public Product(ProductDTO dados) {
        this.product_id = dados.product_id();
        this.productName = dados.productName();
        this.referenceCode = dados.referenceCode();
        this.price = dados.price();
        this.pricePromocional = dados.pricePromocional();
        this.provider = dados.provider();
        this.stockAlert = dados.stockAlert();
        this.color = dados.color();
        this.productSize = dados.size();
        this.barCodeField = dados.barCodeField();
        this.description = dados.description();
        this.category = dados.category();
        this.packagingQuantity = dados.packagingQuantity();
        this.unity = dados.unity();
        this.netWeight = dados.netWeight();
        this.grossWeight = dados.grossWeight();
        this.dimension = dados.dimension();
        this.anvisaRegister = dados.anvisaRegister();
        this.origin = dados.origin();
        this.stockLocation = dados.stockLocation();
        this.icms = dados.icms();
        this.cfop = dados.cfop();
        this.ncm = dados.ncm();
        this.cst = dados.cst();
        this.image = dados.image();
        this.active = dados.active();
        this.sterility = dados.sterility();
        this.freeShipping = dados.freeShipping();
        this.perishable = dados.perishable();
        this.updateDate = dados.updateDate();
        this.updateUser = dados.updateUser();
        this.createUser = dados.createUser();
        this.createDate = dados.createDate();
    }
}