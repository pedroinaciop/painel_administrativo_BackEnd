package com.administrative.painel.service;

import com.administrative.painel.dto.ProductDTO;
import com.administrative.painel.model.Category;
import com.administrative.painel.model.Company;
import com.administrative.painel.model.Product;
import com.administrative.painel.model.Provider;
import com.administrative.painel.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getProducts() {
        return convertData(productRepository.findAll());
    }

    public Product getProductByID(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    public ProductDTO getProductDTO (Long id) {
        return convertProduct(productRepository.findById(id));
    }

    public ProductDTO convertProduct(Optional<Product> product) {
        return product
                .map(p -> new ProductDTO(p.getProduct_id(), p.getProductName(), p.getReferenceCode(), p.getPrice(), p.getPricePromocional(), p.getProvider(), p.getStockAlert(), p.getColor(), p.getProductSize(), p.getBarCodeField(), p.getDescription(), p.getCategory(), p.getPackagingQuantity(), p.getUnity(), p.getNetWeight(), p.getGrossWeight(), p.getDimension(), p.getAnvisaRegister(), p.getOrigin(), p.getStockLocation(), p.getIcms(), p.getCfop(), p.getNcm(), p.getCst(), p.getImage(), p.getActive(), p.getSterility(), p.getFreeShipping(), p.getPerishable(), p.getUpdateDate(), p.getUpdateUser()))
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    private List<ProductDTO> convertData(List<Product> products) {
        return products
            .stream()
            .map(p -> new ProductDTO(p.getProduct_id(), p.getProductName(), p.getReferenceCode(), p.getPrice(), p.getPricePromocional(), p.getProvider(),p.getStockAlert(), p.getColor(), p.getProductSize(), p.getBarCodeField(), p.getDescription(), p.getCategory(), p.getPackagingQuantity(), p.getUnity(), p.getNetWeight(), p.getGrossWeight(), p.getDimension(), p.getAnvisaRegister(), p.getOrigin(), p.getStockLocation(), p.getIcms(), p.getCfop(), p.getNcm(), p.getCst(), p.getImage(), p.getActive(), p.getSterility(), p.getFreeShipping(), p.getPerishable(), p.getUpdateDate(), p.getUpdateUser()))
            .collect(Collectors.toList());
    }

    public void editProduct(Long id, String productName, String referenceCode, BigDecimal price, BigDecimal pricePromocional, Provider provider, Integer stockAlert, String color, String size, String barCodeField, String description, Category category, Integer packagingQuantity, String unity, Double netWeight, Double grossWeight, String dimension, String anvisaRegister, String origin, String stockLocation, BigDecimal icms, String cfop, String ncm, String cst, String image, Boolean active, Boolean sterility, Boolean freeShipping, Boolean perishable,  Date updateDate, String updateUser) {
        Product product = getProductByID(id);

        product.setProductName(productName);
        product.setReferenceCode(referenceCode);
        product.setPrice(price);
        product.setPricePromocional(pricePromocional);
        product.setProvider(provider);
        product.setStockAlert(stockAlert);
        product.setColor(color);
        product.setProductSize(size);
        product.setBarCodeField(barCodeField);
        product.setDescription(description);
        product.setCategory(category);
        product.setPackagingQuantity(packagingQuantity);
        product.setUnity(unity);
        product.setNetWeight(netWeight);
        product.setGrossWeight(grossWeight);
        product.setDimension(dimension);
        product.setAnvisaRegister(anvisaRegister);
        product.setOrigin(origin);
        product.setStockAlert(stockAlert);
        product.setIcms(icms);
        product.setCfop(cfop);
        product.setNcm(ncm);
        product.setCst(cst);
        product.setImage(image);
        product.setActive(active);
        product.setSterility(sterility);
        product.setFreeShipping(freeShipping);
        product.setPerishable(perishable);
        product.setStockLocation(stockLocation);
        product.setUpdateDate(updateDate);
        product.setUpdateUser(updateUser);

        productRepository.save(product);
    }
}
