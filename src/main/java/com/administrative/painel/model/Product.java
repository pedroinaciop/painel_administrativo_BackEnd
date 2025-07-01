package com.administrative.painel.model;

import com.administrative.painel.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.*;

@EqualsAndHashCode(of = "product_id")
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPricePromocional() {
        return pricePromocional;
    }

    public void setPricePromocional(BigDecimal pricePromocional) {
        this.pricePromocional = pricePromocional;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Integer getStockAlert() {
        return stockAlert;
    }

    public void setStockAlert(Integer stockAlert) {
        this.stockAlert = stockAlert;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getBarCodeField() {
        return barCodeField;
    }

    public void setBarCodeField(String barCodeField) {
        this.barCodeField = barCodeField;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getPackagingQuantity() {
        return packagingQuantity;
    }

    public void setPackagingQuantity(Integer packagingQuantity) {
        this.packagingQuantity = packagingQuantity;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getAnvisaRegister() {
        return anvisaRegister;
    }

    public void setAnvisaRegister(String anvisaRegister) {
        this.anvisaRegister = anvisaRegister;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStockLocation() {
        return stockLocation;
    }

    public void setStockLocation(String stockLocation) {
        this.stockLocation = stockLocation;
    }

    public BigDecimal getIcms() {
        return icms;
    }

    public void setIcms(BigDecimal icms) {
        this.icms = icms;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getSterility() {
        return sterility;
    }

    public void setSterility(Boolean sterility) {
        this.sterility = sterility;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Boolean getPerishable() {
        return perishable;
    }

    public void setPerishable(Boolean perishable) {
        this.perishable = perishable;
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

    public String getCreateUser() {
        return createUser;
    }
}

