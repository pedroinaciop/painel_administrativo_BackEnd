package com.administrative.painel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.administrative.painel.repository.ProductRepository;
import com.administrative.painel.service.ProductService;
import org.springframework.web.bind.annotation.*;
import com.administrative.painel.dto.ProductDTO;
import com.administrative.painel.model.Product;
import jakarta.transaction.Transactional;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @GetMapping("/produtos")
    public List<ProductDTO> findAllProducts() {
        return productService.getProducts();
    }

    @Transactional()
    @DeleteMapping("/produtos/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @PostMapping("cadastros/produtos/novo")
    public void createProduct(@RequestBody ProductDTO dados) {
        productRepository.save(new Product(dados));
    }
}
